package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.factory.MysqlDaoFactory;

public class ChangeInspectorService {
    private static final Logger log = LogManager.getLogger(ChangeInspectorService.class);
    private MysqlDaoFactory daoFactory;
    private static ChangeInspectorService instance;

    public static ChangeInspectorService getInstance() {
        if (instance == null) {
            instance = new ChangeInspectorService();
        }
        return instance;
    }

    private ChangeInspectorService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }


}
