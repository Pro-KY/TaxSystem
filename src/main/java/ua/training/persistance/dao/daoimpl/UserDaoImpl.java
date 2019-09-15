package ua.training.persistance.dao.daoimpl;

import ua.training.persistance.beans.User;
import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.util.PropertiesHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

// move all SQl queries to fields or in properties file
public class UserDaoImpl implements IUserDao {
    private MyDataSource myDataSource;
//    private Properties sqlQueries;
    private ResourceBundle sqlQueries;

    public void setMyDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public UserDaoImpl() {
        sqlQueries = PropertiesHandler.getInstance().getSqlProperties();
    }

    public Optional<User> getUserByLoginAndPassword(String login, String password) { // throws DaoException
//        final HashMap<String, String> requestParameters = requestContent.getRequestParameters();
//        final String login = requestParameters.get(Param.LOGIN);
//        final String password = requestParameters.get(Param.PASSWORD);

        Optional<User> optionalUser = Optional.empty();

        if (sqlQueries != null) {
            final String getByLoginAndPasswordQry = sqlQueries.getString("getByLoginAndPassword");

            try (Connection connection = myDataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(getByLoginAndPasswordQry)) {

                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                final ResultSet resultSet = preparedStatement.executeQuery();
                optionalUser = mapRsToUser(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("sql queries is null");
        }

        return optionalUser;

    }

    @Override
    public void create(User user) throws SQLException {
//        final String SQL = "INSERT INTO mydb.user (login, password, user_type_id) VALUES (?, ?, ?)";
//
//        final Connection connection = myDataSource.getConnection();
//        PreparedStatement ps = connection.prepareStatement(SQL);
//
//        try {
//            System.out.println("conn in UserDaoImpl: " + connection.toString());
//
//            ps.setString(1, user.getLogin());
//            ps.setString(2, user.getPassword());
//            ps.setLong(3, user.getUserTypeId());
//
//            final var rowsAffected = ps.executeUpdate();
//
////            sneakyThrow(new SQLException()); //TODO: uncomment later
//            System.out.println("rows inserted: " + rowsAffected);
//        } finally {
//            myDataSource.releaseResources(connection, ps);
//        }
    }

    @Override
    public void update(User user) {
//        final String SQL = "UPDATE mydb.user SET login = ?, password = ?, user_type_id = ? WHERE id = ?";
//
//        try(final var connection = myDataSource.getConnection();
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
    }

    @Override
    public void delete(User user) {
//        final String SQL = "DELETE FROM mydb.user WHERE id = ?";
//
//        try(final var connection = myDataSource.getConnection();
//            PreparedStatement ps = connection.prepareStatement(SQL)) {
//            ps.setLong(1, user.getId());
//
//            final var rowsAffected = ps.executeUpdate();
//            System.out.println("rows deleted: " + rowsAffected);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Optional<User> getById(Long id) {
//        String sql = "SELECT * FROM mydb.user WHERE id = " + id;
//
//        Optional<User> user = Optional.empty();
//
//        try(final var connection = myDataSource.getConnection();
//            final var statement = connection.createStatement();
//            final var resultSet = statement.executeQuery(sql)) {
//
//            while (resultSet.next()) {
//                user = mapRsToUser(resultSet);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return user;
        return null;
    }

    private Optional<User> mapRsToUser(ResultSet rs) {
        Optional<User> optionalUser = Optional.empty();

        try {
            if (rs.next()) {
                final long id = rs.getLong("id");
                final String login = rs.getString("email");
                final String firstName = rs.getString("first_name");
                final String lastName= rs.getString("last_name");
                final String pwd = rs.getString("password");
    //            final long userTypeId = rs.getLong("user_type_id");

                optionalUser = Optional.of(new User(id, firstName, lastName, login, pwd));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return optionalUser;
    }
}
