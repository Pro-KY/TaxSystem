package ua.training.persistance.dao;

import java.sql.*;

public class JdbcQuery {
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection connection;
    private String sql;
    private int rowsAffected;

    public ResultSet getResult() {
        return rs;
    }

    public JdbcQuery(Connection connection, String sql) {
        this.connection = connection;
        this.sql = sql;
    }

    private void setParameters(Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i+1, parameters[i]);
            }
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    public Long saveOrUpdate(Object... parameters) {
        performModyingQuery(parameters);
        long generatedKey = 0L;

        try {
            if(rs.next()) {
                generatedKey = rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }

        return generatedKey;
    }

    public boolean delete(Object... parameters) {
        performModyingQuery(parameters);
        return rowsAffected > 0;
    }

    private void performModyingQuery(Object... parameters) {
        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameters(parameters);
            rowsAffected = ps.executeUpdate();
            rs = ps.getGeneratedKeys();
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    public ResultSet select(Object... parameters) {
        try {
            ps = connection.prepareStatement(sql);
            setParameters(parameters);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    public boolean modifyAll() {
        try {
            ps = connection.prepareStatement(sql);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rowsAffected > 0;
    }

    public PreparedStatement getPs() {
        return ps;
    }

//    public void releaseResources() {
//        try {
//            if(rs != null) { rs.close(); }
//            if(ps != null) {ps.close();}
//            connection.close();
//        } catch (SQLException e) {
//            // log here
//        }
//    }
}
