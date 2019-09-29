package ua.training.persistance.dao;

import java.util.Optional;

public interface IUserDao extends IDao<User> {
    Optional<User> getUserByEmailAndPassword(String login, String password);
}
