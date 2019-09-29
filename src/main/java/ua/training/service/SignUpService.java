package ua.training.service;

import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.dao.factory.MysqlDaoFactory;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.exceptions.ServiceException;

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
        try {
            return userDao.save(userBean);
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
