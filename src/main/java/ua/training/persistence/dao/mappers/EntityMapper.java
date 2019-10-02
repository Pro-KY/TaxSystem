package ua.training.persistence.dao.mappers;

import java.sql.ResultSet;

public abstract class EntityMapper<T> {
    protected T mappedEntity;
    public abstract T mapToEntity(ResultSet resultSet);

    public EntityMapper() { }
    protected String[] columnNames;

    public EntityMapper(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setColumnNameAliesAtIndex(String colName, int index) {
        columnNames[index] = colName;
    }

}
