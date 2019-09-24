package ua.training.persistance.dao;

import java.util.Optional;

public interface IDao<T> {
    Long save(T bean);
    Long update(T bean);
    boolean delete(T bean);
    Optional<T> findById(Long id);
}
