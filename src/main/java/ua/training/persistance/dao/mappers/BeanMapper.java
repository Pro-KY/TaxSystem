package ua.training.persistance.dao.mappers;

import java.sql.ResultSet;

@FunctionalInterface
public interface BeanMapper<T> {
    T mapRow(ResultSet resultSet);
}
