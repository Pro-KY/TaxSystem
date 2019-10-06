package ua.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IUserDao;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.entities.User;

import java.util.Optional;

public class SignInService {
    private static final Logger log = LogManager.getLogger(SignInService.class);
    private MysqlDaoFactory daoFactory;

    public SignInService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    public Optional<User> getAuthorizedUser(String login, String password) {
        final IUserDao userDao = daoFactory.getUserDao();
        final Optional<User> userByEmailAndPassword = userDao.getUserByEmailAndPassword(login, password);
        userByEmailAndPassword.ifPresent(user -> user.setPassword(null));

        return userByEmailAndPassword;
    }
}
