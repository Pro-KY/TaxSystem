package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.SendReportDto;
import ua.training.persistence.dao.IReportApprovalDao;
import ua.training.persistence.dao.IReportDao;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.entities.Report;
import ua.training.persistence.entities.ReportApproval;
import ua.training.persistence.entities.StateApproval;
import ua.training.persistence.entities.TaxType;
import ua.training.persistence.transaction.MysqlTransactionManager;
import ua.training.util.constans.ReportContentType;
import ua.training.util.constans.StateApprovalEnum;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.properties.MessagePropertiesHandler;

import java.sql.Timestamp;
import java.util.Optional;

import static ua.training.util.properties.MessagePropertiesHandler.SERVICE_TRANSACTION_ERROR;

public class SendReportService {
    private static final Logger logger = LogManager.getLogger(SendReportService.class);
    private MysqlDaoFactory daoFactory;

    public SendReportService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    public void saveSentReport(SendReportDto sendReportDto) {
        MysqlTransactionManager tm = new MysqlTransactionManager();
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final StateApproval stateApproval = new StateApproval(StateApprovalEnum.PROCESSING.getStateId());

        Report report;

        if(sendReportDto.getReportContentTypeId() == ReportContentType.FORM.getId()) {
            report = new Report(new TaxType(sendReportDto.getReportTaxtypeId()), sendReportDto.getReportSum(), sendReportDto.getReportQuarter());
            logger.info(report.toString());
        } else {
            final ReportFileService reportFileService = new ReportFileService();
            final Optional<Report> reportOptional = reportFileService.parseReportFile(sendReportDto);

            if (reportOptional.isPresent()) {
                report = reportOptional.get();
            } else {
                throw new ServiceException("error during parsing report file");
            }
        }

        tm.doInTransaction(daoFactory -> {
            final IReportDao reportDao = daoFactory.getReportDao();
            final IReportApprovalDao reportApprovalDao = daoFactory.getReportApprovalDao();
            final Long reportId = reportDao.save(report);
            final ReportApproval reportApproval = new ReportApproval(timestamp, stateApproval, sendReportDto.getUser(), new Report(reportId));

            reportApprovalDao.save(reportApproval);
        });

        if (tm.isRollBacked()) {
            throw new ServiceException(MessagePropertiesHandler.getMessage(SERVICE_TRANSACTION_ERROR));
        }
    }
}
