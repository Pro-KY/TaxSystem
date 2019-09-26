package ua.training.persistance.transaction;


import ua.training.persistance.dao.factory.DaoFactory;
import ua.training.util.ThrowingConsumer;

public interface TransactionManager {
//    void doInTransaction(Consumer<DaoFactory> daoFactoryConsumer) throws SQLException;
    void doInTransaction(ThrowingConsumer<DaoFactory, Exception> daoFactoryConsumer);
    void rollback();
    void commit();
}
