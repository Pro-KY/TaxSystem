package ua.training.persistance.db.datasource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDataSourceImpl implements MysqlDataSource {
    private static MysqlDataSourceImpl instance;
    private DataSource dataSource;

    public static MysqlDataSourceImpl getInstance() {
        if (instance == null) {
            instance = new MysqlDataSourceImpl();
        }
        return instance;
    }

    private MysqlDataSourceImpl() {
        System.out.println("MysqlDataSourceImpl private const is called");
        initDataSource();
    }


    private void initDataSource() {
        try {
            final InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/mysql");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Connection getConnection() {
        Connection conn = null;

        try {
            if (dataSource != null) {
                conn = dataSource.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Can't get DB connection: " + e.toString());
        }

        return conn;
    }

    @Override
    public void releaseResources(Connection conn, Statement statement) {
        System.out.println("releaseResources in mysqlDao");

        try {
            statement.close();
            conn.close();
            System.out.println("statement closed: " + statement.isClosed());
            System.out.println("connection closed: " + conn.isClosed());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
