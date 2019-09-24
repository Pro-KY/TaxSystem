package ua.training.persistance.dao;

import java.util.Optional;

public interface IDao<T> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    Optional<T> getById(Long id);
}
