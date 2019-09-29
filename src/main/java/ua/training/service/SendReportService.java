package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.SendReportDto;
import ua.training.persistance.dao.IReportApprovalDao;
import ua.training.persistance.dao.IReportDao;
import ua.training.persistance.dao.factory.MysqlDaoFactory;
import ua.training.persistance.entities.Report;
import ua.training.persistance.entities.ReportApproval;
import ua.training.persistance.entities.StateApproval;
import ua.training.persistance.entities.TaxType;
import ua.training.persistance.transaction.MysqlTransactionManager;
import ua.training.util.constans.ReportContentType;
import ua.training.util.constans.StateApprovalEnum;
import ua.training.util.exceptions.ServiceException;

import java.sql.Timestamp;
import java.util.Optional;

public class SendReportService {
    private static final Logger LOGGER = LogManager.getLogger(SendReportService.class);
    private MysqlDaoFactory daoFactory;

    public SendReportService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    public void saveSentReport(SendReportDto sendReportDto) {
//        MysqlTransactionManager tm = MysqlTransactionManager.getInstance();
        MysqlTransactionManager tm = new MysqlTransactionManager();
        final ReportApproval reportApproval = new ReportApproval();
//        reportApproval.setSenderId(sendReportDto.getUser().getId());
        reportApproval.setTimestamp(new Timestamp(System.currentTimeMillis()));
        reportApproval.setStateApproval(new StateApproval(StateApprovalEnum.PROCESSING.getStateId()));

        Report report;

        if(sendReportDto.getReportContentTypeId() == ReportContentType.FORM.getId()) {
            report = new Report(new TaxType(sendReportDto.getReportTaxtypeId()), sendReportDto.getReportSum(), sendReportDto.getReportQuarter());

        } else {
//            final Optional<Report> reportOptional = CommandHelper.parseReportFile.apply(sendReportDto);
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
            final IReportApprovalDao iReportApprovalDao = daoFactory.getReportApprovalDao();

            final Long reportId = reportDao.save(report);
            reportApproval.setReport(new Report(reportId));
            iReportApprovalDao.save(reportApproval);
        });

        if (tm.isRollBacked()) {
            // TODO: add error message
            throw new ServiceException("msg");
        }
    }
}
