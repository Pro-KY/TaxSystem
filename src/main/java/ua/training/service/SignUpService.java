package ua.training.service;

import ua.training.persistence.dao.IUserDao;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.entities.User;

public class SignUpService {
    private static SignUpService instance;

    private MysqlDaoFactory daoFactory;

    private SignUpService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    public static SignUpService getInstance() {
        if (instance == null) {
            instance = new SignUpService();
        }
        return instance;
    }

    // return authorized user if one exist in DB
    public Long saveSignedUpUser(User userBean) {
        final IUserDao userDao = daoFactory.getUserDao();
        return userDao.save(userBean);
    }
}
