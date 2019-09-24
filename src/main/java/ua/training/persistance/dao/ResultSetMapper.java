package ua.training.persistance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetMapper<T> {
    public T mapToRow(ResultSet resultSet, long currentRow) throws SQLException;
}
