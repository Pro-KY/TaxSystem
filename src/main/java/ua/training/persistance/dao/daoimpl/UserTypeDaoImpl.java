package ua.training.persistance.dao.daoimpl;

import ua.training.persistance.dao.IUserTypeDao;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.beans.Role;

import java.util.Optional;

public class UserTypeDaoImpl implements IUserTypeDao {
    private MyDataSource myDataSource;

    public void setDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    @Override
    public Long save(Role bean) {
//        final String SQL = "INSERT INTO mydb.use_type (user_type, description) VALUES (?, ?)";
//
//        final var connection = myDataSource.getConnection();
//        PreparedStatement ps = connection.prepareStatement(SQL);
//
//        try {
//            System.out.println("conn in UserTypeDaoImpl: " + connection.toString());
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
        return 1L;
    }

    @Override
    public Long update(Role bean) {
        return 1L;
    }

    @Override
    public boolean delete(Role bean) {
        return false;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    static <T extends Exception, R> R sneakyThrow(Exception t) throws T {
        throw (T) t; // ( ͡° ͜ʖ ͡°)
    }
}
