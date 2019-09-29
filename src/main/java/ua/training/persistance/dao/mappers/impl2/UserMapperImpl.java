package ua.training.persistance.dao.mappers.impl2;

import ua.training.persistance.entities.User;
import ua.training.persistance.entities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperImpl extends EnitityMapper<User> {
    private static String ID = "id";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String ORGANIZATION = "organization";
    private static final String USER_TYPE_ID = "user_type_id";

    private boolean mapUserType;
    private EnitityMapper<UserType> userTypeMapper;

    public UserMapperImpl() {
        columnsIndexes.put(ID, 1);
        columnsIndexes.put(FIRST_NAME, 2);
        columnsIndexes.put(LAST_NAME, 3);
        columnsIndexes.put(ORGANIZATION, 4);
        columnsIndexes.put(EMAIL, 5);
        columnsIndexes.put(PASSWORD, 6);
        columnsIndexes.put(ADDRESS, 7);
        columnsIndexes.put(USER_TYPE_ID, 8);
    }
//
//    private void setUserType() {
//        final UserTypeMapperImpl userTypeMapper = new UserTypeMapperImpl();
//        userTypeMapper.setIndexesInJoinQuery(userTypeColumnsIndexes);
//        final UserType userType = userTypeMapper.mapToEntity(resultSet);
////        final UserType userType = userTypeMapper.getMappedEntity();
//        this.mappedEntity.setUserType(userType);
//    }

    @Override
    public User mapToEntity(ResultSet resultSet) {
        super.resultSet = resultSet;

        try {
            if (resultSet.next()) {
                long id = resultSet.getLong(columnsIndexes.get(ID));
                final String email = resultSet.getString(columnsIndexes.get(EMAIL));
                final String firstName = resultSet.getString(columnsIndexes.get(FIRST_NAME));
                final String lastName= resultSet.getString(columnsIndexes.get(LAST_NAME));
                final String organization = resultSet.getString(columnsIndexes.get(ORGANIZATION));
                final String adress = resultSet.getString(columnsIndexes.get(ADDRESS));
                final String password = resultSet.getString(columnsIndexes.get(PASSWORD));
                final long userTypeId = resultSet.getLong(columnsIndexes.get(USER_TYPE_ID));
//                final String type = resultSet.getString(UserTypeEntityMapperImpl.TYPE);
                final UserType userType = new UserType(userTypeId);

                mappedEntity =  new User(id, firstName, lastName, organization, email, password, adress, userType);

                if (mapUserType) {
                    mappedEntity.setUserType(userTypeMapper.mapToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }
        return mappedEntity;
    }
}
