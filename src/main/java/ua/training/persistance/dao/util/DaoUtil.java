package ua.training.persistance.dao.util;

import ua.training.persistance.dao.mappers.BeanMapper;
import ua.training.util.exceptions.BeanMappingException;

import java.sql.ResultSet;
import java.util.Optional;

public class DaoUtil {
    public static <T> Optional<T> mapResultSetToBean(BeanMapper<T> beanMapper, ResultSet resultSet) throws BeanMappingException {
        return beanMapper.mapRow(resultSet);
    }
}
