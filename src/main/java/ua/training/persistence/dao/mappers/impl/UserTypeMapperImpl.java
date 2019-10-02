package ua.training.persistence.dao.mappers.impl;

import ua.training.persistence.entities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeMapperImpl extends EntityMapper<UserType> {
    private static final String ID = "id";
    private static final String TYPE = "type";

    public UserTypeMapperImpl() {
//        super(resultSet);
        columnsIndexes.put(ID, 1);
        columnsIndexes.put(TYPE, 2);
    }

    @Override
    public UserType mapToEntity(ResultSet resultSet) {
        try {
//            if (resultSet.next()) {
                long id = resultSet.getLong(columnsIndexes.get(ID));
                final String type = resultSet.getString(columnsIndexes.get(TYPE));
               mappedEntity =  new UserType(id, type);
//            }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }
        return mappedEntity;
    }
}
