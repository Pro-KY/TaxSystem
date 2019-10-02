package ua.training.persistence.dao;

import ua.training.persistence.entities.User;

import java.util.Optional;

public interface IUserDao extends IDao<User> {
    Optional<User> getUserByEmailAndPassword(String login, String password);
}
