package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IUserTypeDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.UserTypeMapperImpl;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.UserType;
import ua.training.util.properties.SqlProperties;

import java.util.Optional;

import static ua.training.util.properties.SqlProperties.*;

public class UserTypeDaoImpl implements IUserTypeDao {
    private JdbcTemplate jdbcTemplate;
    private static UserTypeDaoImpl instance;
    private static final Logger logger = LogManager.getLogger(UserTypeDaoImpl.class);

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
        String sql = SqlProperties.getSqlQuery(SAVE_USER_TYPE);
        return jdbcTemplate.saveOrUpdate(sql, entity.getType());
    }

    @Override
    public Optional<UserType> findByType(String type) {
        String sql = SqlProperties.getSqlQuery(FIND_USER_TYPE_BY_TYPE);
        final UserTypeMapperImpl userTypeMapper = new UserTypeMapperImpl(false);
        return jdbcTemplate.findByQuery(sql, userTypeMapper, type);

    }

    @Override
    public Long update(UserType entity) {
        String sql = SqlProperties.getSqlQuery(UPDATE_USER_TYPE);
        return jdbcTemplate.saveOrUpdate(sql, entity.getType(), entity.getId());
    }

    @Override
    public boolean delete(UserType entity) {
        String sql = SqlProperties.getSqlQuery(DELETE_USER_TYPE);
        return jdbcTemplate.delete(sql, entity.getId());
    }

    @Override
    public Optional<UserType> findById(Long id) {
        String sql = SqlProperties.getSqlQuery(SqlProperties.FIND_USER_TYPE_BY_ID);
        final UserTypeMapperImpl userTypeMapper = new UserTypeMapperImpl(false);
        return jdbcTemplate.findByQuery(sql, userTypeMapper, id);
    }
}
