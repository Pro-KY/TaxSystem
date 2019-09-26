package ua.training.persistance.dao.daoimpl;

import ua.training.persistance.beans.UserType;
import ua.training.persistance.dao.IUserTypeDao;
import ua.training.persistance.db.datasource.MyDataSource;

import java.util.Optional;

public class UserTypeDaoImpl implements IUserTypeDao {
    private MyDataSource myDataSource;

    public void setDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    @Override
    public Long save(UserType bean) {
        // stub
        return 1L;
    }

    @Override
    public Long update(UserType bean) {
        return 1L;
    }

    @Override
    public boolean delete(UserType bean) {
        return false;
    }

    @Override
    public Optional<UserType> findById(Long id) {
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    static <T extends Exception, R> R sneakyThrow(Exception t) throws T {
        throw (T) t; // ( ͡° ͜ʖ ͡°)
    }
}
