package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.entities.Report;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.handler.properties.MessagePropertiesHandler;

import static ua.training.util.handler.properties.MessagePropertiesHandler.REPORT_ERROR_MSG;

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
                .orElseThrow(() -> new ServiceException(MessagePropertiesHandler.getMessage(REPORT_ERROR_MSG), reportId));
    }

    public Long updateReport() {
//        TODO: impl
        return null;
    }
}
