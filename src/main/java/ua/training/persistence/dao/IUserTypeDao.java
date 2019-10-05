package ua.training.persistence.dao;


import ua.training.persistence.entities.UserType;

import java.util.Optional;

public interface IUserTypeDao extends IDao<UserType> {
    Optional<UserType> findByType(String type);
}
