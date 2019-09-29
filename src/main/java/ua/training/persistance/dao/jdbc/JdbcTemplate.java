package ua.training.persistance.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.mappers.impl.EnitityMapper;
import ua.training.persistance.db.datasource.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO: refactor as simple object no singleton?
public class JdbcTemplate {
    private static final Logger LOGGER = LogManager.getLogger(JdbcTemplate.class);
    private static JdbcTemplate instance;
    private MysqlDataSource mysqlDataSource;
    public void setDataSource(MysqlDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
    }

    private JdbcTemplate() {}

        public static JdbcTemplate getInstance() {
        if (instance == null) {
            instance = new JdbcTemplate();
        }
        return instance;
    }

    public <T> List<T> finAll(String sql, EnitityMapper<T> entityEnitityMapper, Object... parameters) {
        final Connection connection = mysqlDataSource.getConnection();
        List<T> resultList = new ArrayList<>();

        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        try(final ResultSet result = jdbcQuery1.select(parameters)) {
            while (result.next()) {
                final T t = entityEnitityMapper.mapToEntity(result);
                resultList.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultList = new ArrayList<>();
        }  finally {
            mysqlDataSource.releaseResources(connection, jdbcQuery1.getPs());
        }

        return resultList;
    }

    public <T> Optional<T> findByQuery(String sql, EnitityMapper<T> entityMapper, Object... parameters) {
        final Connection connection = mysqlDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        Optional<T> t;
        try (ResultSet result = jdbcQuery1.select(parameters)) {
            result.next();
            t = Optional.ofNullable(entityMapper.mapToEntity(result));
        } catch (SQLException e) {
            t = Optional.empty();
        }  finally {
            mysqlDataSource.releaseResources(connection, jdbcQuery1.getPs());
        }
        return t;
    }

    public Long countRows(String sql) {
        final Connection connection = mysqlDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        long rowsAmount;
        try (ResultSet result = jdbcQuery1.select()) {
            result.next();
            rowsAmount = result.getLong(1);
        } catch (SQLException e) {
            rowsAmount = 0;
        }  finally {
            mysqlDataSource.releaseResources(connection, jdbcQuery1.getStatement());
        }
        return rowsAmount;
    }

    public Long saveOrUpdate(String sql, Object... parameters) {
        long insertedId;
        final Connection connection = mysqlDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        insertedId = jdbcQuery1.saveOrUpdate(parameters);
        closeResultSet(jdbcQuery1.getResult());
        mysqlDataSource.releaseResources(connection, jdbcQuery1.getPs());
        return insertedId;
    }

    public boolean delete(String sql, Object... parameters) {
        boolean isDeleted;
        final Connection connection = mysqlDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        isDeleted = jdbcQuery1.delete(parameters);
        closeResultSet(jdbcQuery1.getResult());
        mysqlDataSource.releaseResources(connection, jdbcQuery1.getPs());
        return isDeleted;
    }

//    public <T> List<T> getPage(String sql, EnitityMapper<T> beanMapper, Object...params) {
//        return finAll(sql, beanMapper, params);
//    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            // TODO: log here
            e.printStackTrace();
        }
    }
}
