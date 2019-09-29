package ua.training.persistance.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.dao.mappers.impl.UserMapperImpl;
import ua.training.persistance.db.datasource.MysqlDataSource;
import ua.training.persistance.entities.User;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.LOGIN_AND_PASSWORD;
import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_USER;

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
        String sql = SqlPropertiesHandler.getSqlQuery(LOGIN_AND_PASSWORD);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Object[] params = {login, password};
        final UserMapperImpl userMapper = new UserMapperImpl();
        return jdbcTemplate.findByQuery(sql, userMapper, params);
    }

    @Override
    public Long save(User user) {
        Object[] params = {user.getFirstName(), user.getLastName(), user.getOrganization(),
                user.getEmail(), user.getPassword(), user.getAddress(), user.getUserType().getId()};

        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_USER);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            logger.debug("exp here _ 1");
            throw new PersistenceException("", e);
        }
    }

    @Override
    public Long update(User bean) {
//        final String SQL = "UPDATE mydb.user SET login = ?, password = ?, user_type_id = ? WHERE id = ?";
//
//        try(final var connection = dataSource.getConnection();
//            PreparedStatement ps = connection.prepareStatement(SQL)) {
//
////            ps.setString(1, user.getLogin());
////            ps.setString(2, user.getPassword());
////            ps.setLong(3, user.getUserTypeId());
////            ps.setLong(4, user.getId());
//
//            Object[] values = {user.getLogin(), user.getPassword(), user.getUserTypeId(), user.getId()};
//            DbUtil.setValuesToPs(values, ps);
//
//            final var rowsAffected = ps.executeUpdate();
//            System.out.println("rows updated: " + rowsAffected);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return 0L;
    }

    @Override
    public boolean delete(User bean) {
//        final String SQL = "DELETE FROM mydb.user WHERE id = ?";
//
//        try(final var connection = dataSource.getConnection();
//            PreparedStatement ps = connection.prepareStatement(SQL)) {
//            ps.setLong(1, user.getId());
//
//            final var rowsAffected = ps.executeUpdate();
//            System.out.println("rows deleted: " + rowsAffected);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return false;
    }

    @Override
    public Optional<User> findById(Long id) {
//        String sql = "SELECT * FROM mydb.user WHERE id = " + id;
//
//        Optional<User> user = Optional.empty();
//
//        try(final var connection = dataSource.getConnection();
//            final var statement = connection.createStatement();
//            final var resultSet = statement.select(sql)) {
//
//            while (resultSet.getPage()) {
//                user = mapRsToUser(resultSet);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return user;
        return null;
    }

//    private Optional<User> mapRsToUser(ResultSet rs) {
//        Optional<User> optionalUser = Optional.empty();
//
//        try {
//            if (rs.getPage()) {
//                final long id = rs.getLong("id");
//                final String login = rs.getString("email");
//                final String firstName = rs.getString("first_name");
//                final String lastName= rs.getString("last_name");
//                final String pwd = rs.getString("password");
//    //            final long userTypeId = rs.getLong("user_type_id");
//
//                optionalUser = Optional.of(new User(id, firstName, lastName, login, pwd));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return optionalUser;
//    }
}
