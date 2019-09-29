package ua.training.persistance.transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.factory.DaoFactory;
import ua.training.persistance.dao.factory.MysqlDaoFactory;
import ua.training.persistance.db.datasource.MysqlMysqlDataSource;
import ua.training.persistance.db.datasource.MysqlMysqlDataSourceProxy;
import ua.training.util.ThrowingConsumer;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlTransactionManager implements TransactionManager {
    private static MysqlTransactionManager instance;
    private static final Logger logger = LogManager.getLogger(MysqlTransactionManager.class);
    private DaoFactory mySQLDaoFactory;
    private MysqlMysqlDataSourceProxy mysqlDataSourceProxy;
    private Connection connection;
    private boolean isRollBacked;

//    public static MysqlTransactionManager getInstance() {
//        if (instance == null) {
//            instance = new MysqlTransactionManager();
//        }
//        return instance;
//    }

    public MysqlTransactionManager() {
        mySQLDaoFactory = MysqlDaoFactory.getInstance();
        mysqlDataSourceProxy = new MysqlMysqlDataSourceProxy(MysqlMysqlDataSource.getInstance());
        mySQLDaoFactory.setDataSource(mysqlDataSourceProxy);
    }

    @Override
    public void doInTransaction(ThrowingConsumer<DaoFactory, Exception> daoFactoryConsumer) { // Consumer<DaoFactory> daoFactoryConsumer
        isRollBacked = false;

        try {
            connection = mysqlDataSourceProxy.getConnection();
            connection.setAutoCommit(false);
            daoFactoryConsumer.accept(mySQLDaoFactory);
            commit();
        } catch(Exception e) {
            logger.debug("exp here.. =(");
            isRollBacked = true;
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
