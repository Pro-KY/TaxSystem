package ua.training.persistance.transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.factory.DaoFactory;
import ua.training.persistance.dao.factory.MySQLDaoFactory;
import ua.training.persistance.db.datasource.MysqlMyDataSource;
import ua.training.persistance.db.datasource.MysqlMyDataSourceProxy;
import ua.training.util.exceptions.ThrowingConsumer;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlTransactionManager implements TransactionManager {
    private static MysqlTransactionManager instance;
    private static final Logger logger = LogManager.getLogger(MysqlTransactionManager.class);
    private DaoFactory mySQLDaoFactory;
    private MysqlMyDataSourceProxy mysqlDataSourceProxy;
    private Connection connection;


    public static MysqlTransactionManager getInstance() {
        if (instance == null) {
            instance = new MysqlTransactionManager();
        }
        return instance;
    }

    private MysqlTransactionManager() {
        mySQLDaoFactory = new MySQLDaoFactory();
        mysqlDataSourceProxy = new MysqlMyDataSourceProxy(MysqlMyDataSource.getInstance());
        mySQLDaoFactory.setMyDataSource(mysqlDataSourceProxy);
    }

    @Override
    public void doInTransaction(ThrowingConsumer<DaoFactory, Exception> daoFactoryConsumer) { // Consumer<DaoFactory> daoFactoryConsumer
        try {
            connection = mysqlDataSourceProxy.getConnection();
            connection.setAutoCommit(false);
            daoFactoryConsumer.accept(mySQLDaoFactory);
            commit();
        } catch(Exception e) {
            logger.debug("exp here.. =(");
            rollback();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
                logger.debug("close connection, is closed = " + connection.isClosed());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
