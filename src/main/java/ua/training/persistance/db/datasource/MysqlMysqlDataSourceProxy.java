package ua.training.persistance.db.datasource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlMysqlDataSourceProxy implements MysqlDataSource {
    private static final Logger logger = LogManager.getLogger(MysqlMysqlDataSourceProxy.class);
    private MysqlMysqlDataSource mysqlDataSource;
    private Connection connection;

    public MysqlMysqlDataSourceProxy(MysqlMysqlDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
    }

    @Override
    public Connection getConnection() {
        if (connection == null) {
            logger.info("getConnection is null");
            connection = mysqlDataSource.getConnection();
        } else {
            logger.info("getConnection IS NOT null");
        }

        return connection;
    }

    @Override
    public void releaseResources(Connection conn, Statement statement) {
        System.out.println("releaseResources in proxy");
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
