package ua.training.persistance.dao.mappers;

import java.sql.ResultSet;

@FunctionalInterface
public interface EnitityMapper<T> {
    T mapRow(ResultSet resultSet);
}
