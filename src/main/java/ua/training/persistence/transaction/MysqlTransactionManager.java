package ua.training.persistence.transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.factory.DaoFactory;
import ua.training.persistence.dao.factory.MysqlDaoFactory;
import ua.training.persistence.db.datasource.MysqlDataSourceImpl;
import ua.training.persistence.db.datasource.MysqlDataSourceProxy;
import ua.training.util.ThrowingConsumer;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlTransactionManager implements TransactionManager {
    private static final Logger logger = LogManager.getLogger(MysqlTransactionManager.class);
    private DaoFactory mySQLDaoFactory;
    private MysqlDataSourceProxy mysqlDataSourceProxy;
    private Connection connection;
    private boolean isRollBacked;


    public MysqlTransactionManager() {
        mySQLDaoFactory = MysqlDaoFactory.getInstance();
        mysqlDataSourceProxy = new MysqlDataSourceProxy(MysqlDataSourceImpl.getInstance());
        mySQLDaoFactory.setDataSource(mysqlDataSourceProxy);
    }

    @Override
    public void doInTransaction(ThrowingConsumer<DaoFactory, Exception> daoFactoryConsumer) {
        isRollBacked = false;

        try {
            connection = mysqlDataSourceProxy.getConnection();
            connection.setAutoCommit(false);
            daoFactoryConsumer.accept(mySQLDaoFactory);
            commit();
        } catch(Exception e) {
            isRollBacked = true;
            rollback();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
                mySQLDaoFactory.setDataSource(MysqlDataSourceImpl.getInstance());
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

    public boolean isRollBacked() {
        return isRollBacked;
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
