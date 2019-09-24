package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.ITaxTypeDao;
import ua.training.persistance.dao.factory.MySQLDaoFactory;
import ua.training.persistance.entities.*;
import ua.training.persistance.transaction.MysqlTransactionManager;

import java.sql.Timestamp;
import java.util.Optional;

public class SendReportService {
    private static final Logger LOGGER = LogManager.getLogger(SendReportService.class);

    private MySQLDaoFactory daoFactory;
//    PROCESSING("processing"), CANCELED("canceled"), REQUIRE_CHANGES("require changes"), APPROVED("approved");
    private static final String REPORT_STATE_PROCESSING = "processing";

    public SendReportService() {
        this.daoFactory = MySQLDaoFactory.getInstance();
    }

    public boolean saveSentReport(Report sentReport, User sender) {
        MysqlTransactionManager tm = MysqlTransactionManager.getInstance();

        final SendReportEvent sendReportEvent = new SendReportEvent.Builder()
                .date(new Timestamp(System.currentTimeMillis()))
                .report(sentReport)
                .user(sender)
                .reportState(new ReportState(REPORT_STATE_PROCESSING))
                .build();

        tm.doInTransaction(daoFactory -> {
            final ITaxTypeDao taxTypeDao = daoFactory.getTaxTypeDao();
            final Optional<TaxType> taxTypeOptional = taxTypeDao.getTaxTypeByType(sentReport.getTaxType());
            final TaxType taxType = taxTypeOptional.orElseThrow(RuntimeException::new);
            sentReport.setTaxType(taxType);

            // getReport state id
            // saveReport
            // put all into SendReportEvent
            // pass it into SendReportEventDao => save
        });

        return false;
    }
}
