package ua.training.persistence.dao;

import ua.training.persistence.entities.User;
import ua.training.persistence.entities.UserType;

import java.util.List;
import java.util.Optional;

public interface IUserDao extends IDao<User> {
    Optional<User> getUserByEmailAndPassword(String login, String password);
    List<User> findAllByUserTypeAndIdNotEqual(UserType userType, Long id);
}
