package ua.training.persistance.db.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlMyDataSourceProxy implements MyDataSource {
    private MysqlMyDataSource mysqlDataSource;
    private Connection connection;

    public MysqlMyDataSourceProxy(MysqlMyDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
    }

    @Override
    public Connection getConnection() {
        if (connection == null) {
            connection = mysqlDataSource.getConnection();
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
