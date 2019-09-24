package ua.training.persistance.dao.mappers;

import java.sql.ResultSet;

@FunctionalInterface
public interface Mapper<T> {
    T mapRow(ResultSet resultSet);
}
