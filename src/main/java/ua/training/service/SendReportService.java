package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.SendReportDto;
import ua.training.persistance.beans.Report;
import ua.training.persistance.beans.SendReportEvent;
import ua.training.persistance.dao.IReportDao;
import ua.training.persistance.dao.ISendReportEventDao;
import ua.training.persistance.dao.factory.MySQLDaoFactory;
import ua.training.persistance.transaction.MysqlTransactionManager;
import ua.training.util.constans.ReportContentType;
import ua.training.util.constans.ReportStateEnum;
import ua.training.util.exceptions.ServiceException;

import java.sql.Timestamp;
import java.util.Optional;

public class SendReportService {
    private static final Logger LOGGER = LogManager.getLogger(SendReportService.class);
    private MySQLDaoFactory daoFactory;

    public SendReportService() {
        this.daoFactory = MySQLDaoFactory.getInstance();
    }

    public void saveSentReport(SendReportDto sendReportDto) {
//        MysqlTransactionManager tm = MysqlTransactionManager.getInstance();
        MysqlTransactionManager tm = new MysqlTransactionManager();
        final SendReportEvent sendReportEvent = new SendReportEvent();
        sendReportEvent.setSenderId(sendReportDto.getUser().getId());
        sendReportEvent.setTimestamp(new Timestamp(System.currentTimeMillis()));
        sendReportEvent.setReportStateId(ReportStateEnum.PROCESSING.getStateId());

        Report report;

        if(sendReportDto.getReportContentTypeId() == ReportContentType.FORM.getId()) {
            report = new Report(sendReportDto.getReportTaxtypeId(), sendReportDto.getReportSum(), sendReportDto.getReportQuarter());
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
            final ISendReportEventDao sendReportEventDao = daoFactory.getSendReportEventDao();
            final Long reportId = reportDao.save(report);
            sendReportEvent.setReportId(reportId);
            sendReportEventDao.save(sendReportEvent);
        });

        if (tm.isRollBacked()) {
            // TODO: add error message
            throw new ServiceException("msg");
        }
    }
}
