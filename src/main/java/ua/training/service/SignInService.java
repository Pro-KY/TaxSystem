package ua.training.service;

import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.dao.factory.MysqlDaoFactory;

import java.util.Optional;

public class SignInService {
    // userDao;
    private MysqlDaoFactory daoFactory;

    public SignInService() {
        this.daoFactory = MysqlDaoFactory.getInstance();
    }

    // return authorized user if one exist in DB
    public Optional<User> getAuthorizedUser(String login, String password) {
        final IUserDao userDao = daoFactory.getUserDao();
        final Optional<User> userByEmailAndPassword = userDao.getUserByEmailAndPassword(login, password);

        userByEmailAndPassword.ifPresent(user -> {
            user.setPassword(null);
        });

        return userByEmailAndPassword;
    }
}
