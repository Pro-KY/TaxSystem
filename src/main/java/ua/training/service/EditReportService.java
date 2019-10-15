package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.ReportDto;
import ua.training.persistence.dao.IReportApprovalDao;
import ua.training.persistence.dao.IReportDao;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.entities.Report;
import ua.training.persistence.entities.ReportApproval;
import ua.training.persistence.entities.StateApproval;
import ua.training.persistence.entities.TaxType;
import ua.training.persistence.transaction.MysqlTransactionManager;
import ua.training.util.constans.StateApprovalEnum;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.properties.MessageProperties;

import static ua.training.util.properties.MessageProperties.*;

public class EditReportService {
    private static final Logger log = LogManager.getLogger(EditReportService.class);
    private MysqlDaoFactory daoFactory;
    private static EditReportService instance;

    public static EditReportService getInstance() {
        if (instance == null) {
            instance = new EditReportService();
        }
        return instance;
    }

    private EditReportService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    public Report findReportById(Long reportId) {
        return daoFactory
                .getReportDao()
                .findById(reportId)
                .orElseThrow(() -> new ServiceException(MessageProperties.getMessage(SERVICE_NULL_ENTITY_ERROR), reportId));
    }

    public void updateReport(ReportDto reportDto, Long reportApprovalId) {
        MysqlTransactionManager tm = new MysqlTransactionManager();
        final StateApproval stateApproval = new StateApproval(StateApprovalEnum.CHANGED.getStateId());
        final Report report = new Report(reportDto.getReportId(), new TaxType(reportDto.getTaxTypeId()), reportDto.getSum(), reportDto.getQuarterId());

        tm.doInTransaction(daoFactory -> {
            final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();
            final IReportDao reportDao = daoFactory.getReportDao();
            final ReportApproval reportApproval = reportApprovalDao.findById(reportApprovalId)
                    .orElseThrow(() -> new ServiceException(MessageProperties.getMessage(SERVICE_NULL_ENTITY_ERROR)));
            reportApproval.setStateApproval(stateApproval);

            reportDao.update(report);
            reportApprovalDao.update(reportApproval);
        });

        if (tm.isRollBacked()) {
            throw new ServiceException(MessageProperties.getMessage(SERVICE_TRANSACTION_ERROR));
        }
    }
}
