package ua.training.persistence.dao.mappers.impl;

import ua.training.persistence.dao.mappers.EntityMapper;
import ua.training.persistence.entities.User;
import ua.training.persistence.entities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperImpl extends EntityMapper<User> {
    private static final String ID = "id";
    private static final String USER_ALIAS_IN_JOIN = "u_id";
    private static final String INSPECTOR_ALIAS_IN_JOIN = "i_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String ORGANIZATION = "organization";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ADDRESS = "address";
    private static final String USER_TYPE_ID = "user_type_id";

    private boolean mapUserType;
    private EntityMapper<UserType> userTypeEntityMapper;

//    public UserMapperImpl(boolean useInJoin) {
//        String idColumn = useInJoin ? USER_ALIAS_IN_JOIN : ID;
//        columnNames = new String[]{idColumn, FIRST_NAME, LAST_NAME, ORGANIZATION, EMAIL, PASSWORD, ADDRESS, USER_TYPE_ID};
//    }

    public UserMapperImpl(boolean useInJoin, boolean isInspector) {
        String idColumn;

       if(useInJoin) {
           idColumn = isInspector ? INSPECTOR_ALIAS_IN_JOIN : USER_ALIAS_IN_JOIN;
       } else {
           idColumn = ID;
       }

        columnNames = new String[]{idColumn, FIRST_NAME, LAST_NAME, ORGANIZATION, EMAIL, PASSWORD, ADDRESS, USER_TYPE_ID};
    }

    @Override
    public User mapToEntity(ResultSet resultSet) {

        try {
                long id = resultSet.getLong(columnNames[0]);
                final String firstName = resultSet.getString(columnNames[1]);
                final String lastName= resultSet.getString(columnNames[2]);
                final String organization = resultSet.getString(columnNames[3]);
                final String email = resultSet.getString(columnNames[4]);
                final String password = resultSet.getString(columnNames[5]);
                final String address = resultSet.getString(columnNames[6]);
                final long userTypeId = resultSet.getLong(columnNames[7]);
                final UserType userType = new UserType(userTypeId);

                mappedEntity =  new User(id, firstName, lastName, organization, email, password, address, userType);

                if (mapUserType) {
                    mappedEntity.setUserType(userTypeEntityMapper.mapToEntity(resultSet));
                }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getCause().toString());
        }
        return mappedEntity;
    }

    public void mapUserTypeRelation(EntityMapper<UserType> userTypeEntityMapper) {
        this.userTypeEntityMapper = userTypeEntityMapper;
        mapUserType = true;
    }
}
