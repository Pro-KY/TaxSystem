package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.*;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.entities.*;
import ua.training.persistence.transaction.MysqlTransactionManager;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.handler.properties.MessagePropertiesHandler;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import static ua.training.util.handler.properties.MessagePropertiesHandler.SERVICE_NULL_ENTITY_ERROR;
import static ua.training.util.handler.properties.MessagePropertiesHandler.SERVICE_TRANSACTION_ERROR;

public class InspectorChangingService {
    private static final Logger log = LogManager.getLogger(InspectorChangingService.class);
    private MysqlDaoFactory daoFactory;
    private static InspectorChangingService instance;
    private final String INSPECTOR_TYPE = "inspector";
    private final String STATE_APPROVAL_PROCESSING = "processing";

    public static InspectorChangingService getInstance() {
        if (instance == null) {
            instance = new InspectorChangingService();
        }
        return instance;
    }

    private InspectorChangingService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    public void changeInspector(Long previousInspectorId, Long reportApprovalId) {
        MysqlTransactionManager tm = new MysqlTransactionManager();
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final ServiceException serviceException = new ServiceException(MessagePropertiesHandler.getMessage(SERVICE_NULL_ENTITY_ERROR));

        tm.doInTransaction(daoFactory -> {
            final IUserDao userDao = daoFactory.getUserDao();
            final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();
            final IInspectorChangingDao inspectorChangingDao = daoFactory.getInspectorChangingDao();
            final IUserTypeDao userTypeDao = daoFactory.getUserTypeDao();
            final IStateApprovalDao stateApprovalDao = daoFactory.getStateApprovalDao();

            final UserType userType = userTypeDao.findByType(INSPECTOR_TYPE).orElseThrow(() -> serviceException);
            final List<User> allInspectorsExceptPreviousList = userDao.findAllByUserTypeAndIdNotEqual(userType, previousInspectorId);
            int randomIndex = new Random().nextInt(allInspectorsExceptPreviousList.size());
            User newInspector = allInspectorsExceptPreviousList.get(randomIndex);
            log.info("newInspector = {}", newInspector.toString());

            // save in changing_inspector
            final User inspector = userDao.findById(previousInspectorId).orElseThrow(() -> serviceException);
            final ReportApproval reportApproval = reportApprovalDao.findById(reportApprovalId).orElseThrow(() -> serviceException);

            final InspectorChanging inspectorChanging = new InspectorChanging(timestamp, reportApproval, inspector);
            inspectorChangingDao.save(inspectorChanging);

            // save in report_approval
            final StateApproval stateApproval = stateApprovalDao.findByState(STATE_APPROVAL_PROCESSING).orElseThrow(() -> serviceException);
            reportApproval.setStateApproval(stateApproval);
            reportApproval.setInspector(newInspector);

            reportApprovalDao.update(reportApproval);
        });

        if (tm.isRollBacked()) {
            throw new ServiceException(MessagePropertiesHandler.getMessage(SERVICE_TRANSACTION_ERROR));
        }
    }
}
