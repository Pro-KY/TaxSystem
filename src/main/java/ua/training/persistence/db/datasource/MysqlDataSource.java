package ua.training.persistence.db.datasource;

import java.sql.Connection;
import java.sql.Statement;


public interface MysqlDataSource {
    Connection getConnection();
    void releaseResources(Connection conn, Statement statement);
}
