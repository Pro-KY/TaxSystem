package ua.training.persistance.dao.daoimpl;

import ua.training.persistance.dao.IRoleDao;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.beans.Role;

import java.sql.SQLException;
import java.util.Optional;

public class RoleDaoImpl implements IRoleDao {
    private MyDataSource myDataSource;

    public void setMyDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    @Override
    public void create(Role userType) throws SQLException {
//        final String SQL = "INSERT INTO mydb.use_type (user_type, description) VALUES (?, ?)";
//
//        final var connection = myDataSource.getConnection();
//        PreparedStatement ps = connection.prepareStatement(SQL);
//
//        try {
//            System.out.println("conn in RoleDaoImpl: " + connection.toString());
//
//            ps.setString(1, userType.getUserType());
//            ps.setString(2, userType.getDescription());
//
//            final var rowsAffected = ps.executeUpdate();
//
////            sneakyThrow(new SQLException());
//
//            System.out.println("rows inserted: " + rowsAffected);
//        } finally {
//            myDataSource.releaseResources(connection, ps);
//        }
    }

    @Override
    public void update(Role userType) {

    }

    @Override
    public void delete(Role userType) {

    }

    @Override
    public Optional<Role> getById(Long id) {
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    static <T extends Exception, R> R sneakyThrow(Exception t) throws T {
        throw (T) t; // ( ͡° ͜ʖ ͡°)
    }
}
