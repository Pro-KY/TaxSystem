package ua.training.persistence.dao.impl;

import ua.training.persistence.dao.IUserTypeDao;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.UserType;

import java.util.Optional;

public class UserTypeDaoImpl implements IUserTypeDao {
    private MysqlDataSource mysqlDataSource;

    public void setDataSource(MysqlDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
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
