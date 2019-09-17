package ua.training.persistance.dao.mappers.junk;

import ua.training.util.exceptions.BeanMappingException;

import java.sql.ResultSet;
import java.util.Optional;

@FunctionalInterface
public interface RowMapper<T> {
    Optional<T> mapRow(ResultSet resultSet) throws BeanMappingException;
}
