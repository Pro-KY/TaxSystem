package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IUserDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.UserMapperImpl;
import ua.training.persistence.dao.mappers.impl.UserTypeMapperImpl;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.User;
import ua.training.persistence.entities.UserType;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.List;
import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.*;

// move all SQl queries to fields or in properties file
public class UserDaoImpl implements IUserDao {
    private static UserDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    public void setDataSource(MysqlDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private UserDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public Optional<User> getUserByEmailAndPassword(String login, String password)  {
        String sql = SqlPropertiesHandler.getSqlQuery(FIND_BY_LOGIN_AND_PASSWORD);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        final UserMapperImpl userMapper = new UserMapperImpl(true, false);
        userMapper.mapUserTypeRelation(new UserTypeMapperImpl(true));
        return jdbcTemplate.findByQuery(sql, userMapper, login, password);
    }

    @Override
    public Long save(User entity) {
        Object[] params = {entity.getFirstName(), entity.getLastName(), entity.getOrganization(),
                entity.getEmail(), entity.getPassword(), entity.getAddress(), entity.getUserType().getId()};

        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_USER);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            logger.debug(e.getMessage(), e.getCause());
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public Long update(User entity) {
        return 0L;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = SqlPropertiesHandler.getSqlQuery(FIND_USER_BY_ID);
        final UserMapperImpl userMapper = new UserMapperImpl(false, false);
        return jdbcTemplate.findByQuery(sql, userMapper, id);
    }

    public List<User> findAllByUserTypeAndIdNotEqual(UserType userType, Long id) {
        String sql = SqlPropertiesHandler.getSqlQuery(FIND_USER_BY_USER_TYPE_AND_NOT_EQUAL_ID);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        final UserMapperImpl userMapper = new UserMapperImpl(false, false);
        return jdbcTemplate.finAll(sql, userMapper, userType.getId(), id);
    }
}
