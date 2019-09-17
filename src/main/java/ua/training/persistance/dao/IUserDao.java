package ua.training.persistance.dao;

import ua.training.persistance.beans.User;
import ua.training.util.RequestContent;
import ua.training.util.exceptions.DaoException;

import java.sql.SQLException;
import java.util.Optional;

public interface IUserDao extends IDao<User> {
    Optional<User> getUserByLoginAndPassword(String login, String password);
}
