package ua.training.service;

import ua.training.persistance.entities.User;
import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.dao.factory.MySQLDaoFactory;

import java.util.Optional;

public class SignInService {
    // userDao;
    private MySQLDaoFactory daoFactory;

    public SignInService() {
        this.daoFactory = MySQLDaoFactory.getInstance();
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
