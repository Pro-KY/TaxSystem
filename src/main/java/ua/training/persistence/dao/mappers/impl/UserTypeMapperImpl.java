package ua.training.persistence.dao.mappers.impl;

import ua.training.persistence.dao.mappers.EntityMapper;
import ua.training.persistence.entities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeMapperImpl extends EntityMapper<UserType> {
    private static final String ID = "id";
    private static final String ID_IN_JOIN = "ut_id";
    private static final String TYPE = "type";


    public UserTypeMapperImpl(boolean usedInJoin) {
        String idColumn = usedInJoin ? ID_IN_JOIN : ID;
        columnNames = new String[]{idColumn, TYPE};
    }

    @Override
    public UserType mapToEntity(ResultSet resultSet) {
        try {
            long id = resultSet.getLong(columnNames[0]);
            final String type = resultSet.getString(columnNames[1]);
            mappedEntity =  new UserType(id, type);
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }
        return mappedEntity;
    }
}
