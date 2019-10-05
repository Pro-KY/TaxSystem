package ua.training.persistence.dao.impl;

import ua.training.persistence.dao.IUserTypeDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.UserTypeMapperImpl;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.UserType;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.USER_TYPE_BY_TYPE;

public class UserTypeDaoImpl implements IUserTypeDao {
    private JdbcTemplate jdbcTemplate;
    private static UserTypeDaoImpl instance;

    public void setDataSource(MysqlDataSource mysqlDataSource) {
        jdbcTemplate.setDataSource(mysqlDataSource);
    }

    private UserTypeDaoImpl() {
        this.jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static UserTypeDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserTypeDaoImpl();
        }
        return instance;
    }


    @Override
    public Long save(UserType entity) {
        //TODO: implement
        return 1L;
    }

    @Override
    public Optional<UserType> findByType(String type) {
        String sql = SqlPropertiesHandler.getSqlQuery(USER_TYPE_BY_TYPE);
        final UserTypeMapperImpl userTypeMapper = new UserTypeMapperImpl(false);
        return jdbcTemplate.findByQuery(sql, userTypeMapper, type);
    }

    @Override
    public Long update(UserType entity) {
        //TODO: implement
        return 1L;
    }

    @Override
    public boolean delete(UserType entity) {
        //TODO: implement
        return false;
    }

    @Override
    public Optional<UserType> findById(Long id) {
        //TODO: implement
        return Optional.empty();
    }
}
