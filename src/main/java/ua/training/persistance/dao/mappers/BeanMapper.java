package ua.training.persistance.dao.mappers;

import ua.training.util.exceptions.BeanMappingException;

import java.sql.ResultSet;
import java.util.Optional;

@FunctionalInterface
public interface BeanMapper<T> {
    Optional<T> mapRow(ResultSet resultSet) throws BeanMappingException;
}
