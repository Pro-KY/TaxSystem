package ua.training.persistance.dao;

import java.sql.SQLException;
import java.util.Optional;

public interface IDao<T> {
    void create(T user) throws SQLException;
    void update(T user) throws SQLException;
    void delete(T user) throws SQLException;
    Optional<T> getById(Long id) throws SQLException;
}
