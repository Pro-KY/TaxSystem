package ua.training.persistance.dao;

import ua.training.persistance.entities.User;

import java.util.Optional;

public interface IUserDao extends IDao<User> {
    Optional<User> getUserByEmailAndPassword(String login, String password);
}
