package ua.training.persistance.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.mappers.EnitityMapper;
import ua.training.persistance.db.datasource.MyDataSource;

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
    private MyDataSource myDataSource;
    public void setDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    private JdbcTemplate() {}

        public static JdbcTemplate getInstance() {
        if (instance == null) {
            instance = new JdbcTemplate();
        }
        return instance;
    }

//    Function<ResultSet, List<T>> function
    public <T> List<T> finAll(String sql, EnitityMapper<T> entityEnitityMapper, Object... parameters) {
        final Connection connection = myDataSource.getConnection();
        List<T> resultList = new ArrayList<>();

        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        try(final ResultSet result = jdbcQuery1.select(parameters)) {
            while (result.next()) {
                final T t = entityEnitityMapper.mapRow(result);
                resultList.add(t);
            }
        } catch (SQLException e) {
            resultList = new ArrayList<>();
        }  finally {
            myDataSource.releaseResources(connection, jdbcQuery1.getPs());
        }

        return resultList;
    }

    public <T> Optional<T> findByQuery(String sql, EnitityMapper<T> entityEnitityMapper, Object... parameters) {
        final Connection connection = myDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        Optional<T> t;
        try (ResultSet result = jdbcQuery1.select(parameters)) {
            t = Optional.ofNullable(entityEnitityMapper.mapRow(result));
        } catch (SQLException e) {
            t = Optional.empty();
        }  finally {
            myDataSource.releaseResources(connection, jdbcQuery1.getPs());
        }
        return t;
    }

    public Long countRows(String sql) {
        final Connection connection = myDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        long rowsAmount;
        try (ResultSet result = jdbcQuery1.select()) {
            rowsAmount = result.getLong(1);
        } catch (SQLException e) {
            rowsAmount = 0;
        }  finally {
            myDataSource.releaseResources(connection, jdbcQuery1.getPs());
        }
        return rowsAmount;
    }

    public Long saveOrUpdate(String sql, Object... parameters) {
        long insertedId;
        final Connection connection = myDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        insertedId = jdbcQuery1.saveOrUpdate(parameters);
        closeResultSet(jdbcQuery1.getResult());
        myDataSource.releaseResources(connection, jdbcQuery1.getPs());
        return insertedId;
    }

    public boolean delete(String sql, Object... parameters) {
        boolean isDeleted;
        final Connection connection = myDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        isDeleted = jdbcQuery1.delete(parameters);
        closeResultSet(jdbcQuery1.getResult());
        myDataSource.releaseResources(connection, jdbcQuery1.getPs());
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
