package ua.training.persistance.dao.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.JdbcQuery;
import ua.training.persistance.dao.mappers.Mapper;
import ua.training.persistance.db.datasource.MyDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTemplate {
    private static final Logger LOGGER = LogManager.getLogger(JdbcTemplate.class);
    private static JdbcTemplate instance;
    private MyDataSource myDataSource;
    public void setDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public static JdbcTemplate getInstance() {
        if (instance == null) {
            instance = new JdbcTemplate();
        }
        return instance;
    }

//    Function<ResultSet, List<T>> function
    public <T> List<T> finAll(String sql, Mapper <T> mapper, Object... parameters) {
        final Connection connection = myDataSource.getConnection();
        List<T> resultList = new ArrayList<>();

        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        try(final ResultSet result = jdbcQuery1.select(parameters)) {
            while (result.next()) {
                final T t = mapper.mapRow(result);
                resultList.add(t);
            }
        } catch (SQLException e) {
            resultList = new ArrayList<>();
        }  finally {
            myDataSource.releaseResources(connection, jdbcQuery1.getPs());
        }

        return resultList;
    }

    public <T> Optional<T> findByQuery(String sql, Mapper<T> mapper, Object... parameters) {
        final Connection connection = myDataSource.getConnection();
        final JdbcQuery jdbcQuery1 = new JdbcQuery(connection, sql);
        Optional<T> t;
        try (ResultSet result = jdbcQuery1.select(parameters)) {
            t = Optional.ofNullable(mapper.mapRow(result));
        } catch (SQLException e) {
            t = Optional.empty();
        }  finally {
            myDataSource.releaseResources(connection, jdbcQuery1.getPs());
        }
        return t;
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


//    public static <T> Optional<T> mapResultSetToBean(Mapper<T> entityMapper, ResultSet resultSet) throws BeanMappingException {
//        return entityMapper.mapRow(resultSet);
//    }

//    public <T> T perfromQuery(String queryName, Function<ResultSet, T> resultSetHandler, Object...parameters) {
//        final String sqlQuery = SqlPropertiesHandler.getSqlQuery(queryName);
//
//        boolean isDeleted = false;
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
//
//            for (int i = 0; i < parameters.length; i++) {
//                preparedStatement.setObject(i+1, parameters[i]);
//            }
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            isDeleted = rowsAffected >= 1;
//        } catch (SQLException e) {
//            LOGGER.error("can't save entity into DB due to error, cause: " + e.getMessage());
//        }
//
//        return isDeleted;
//    }


//    public static void select(Connection connection,
//                              String sql,
//                              JdbcQuery processor,
//                              Object... params) {
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            int cnt = 0;
//            for (Object param : params) {
//                ps.setObject(++cnt, param));
//            }
//            try (ResultSet rs = ps.executeQuery()) {
//                long rowCnt = 0;
//                while (rs.next()) {
//                    processor.process(rs, rowCnt++);
//                }
//            } catch (SQLException e) {
//                throw new DataAccessException(e);
//            }
//        } catch (SQLException e) {
//            throw new DataAccessException(e);
//        }
//    }

//    public <T> boolean modifyAll(String queryName, Function<T, Object[]> paramsExtractor, T entity) {
//        final String sqlQuery = SqlPropertiesHandler.getSqlQuery(queryName);
//
//        boolean isDeleted = false;
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
//            final Object[] parameters = paramsExtractor.apply(entity);
//
//            for (int i = 0; i < parameters.length; i++) {
//                preparedStatement.setObject(i+1, parameters[i]);
//            }
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            isDeleted = rowsAffected >= 1;
//        } catch (SQLException e) {
//            LOGGER.error("can't save entity into DB due to error, cause: " + e.getMessage());
//        }
//
//        return isDeleted;
//    }




//    // returns saved entity id
//    public <T> int modifyOne(String queryName, Function<T, Object[]> paramsExtractor, T entity) {
//        final String sqlQuery = SqlPropertiesHandler.getSqlQuery(queryName);
//
//        int entityId = 0;
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
//
//            final Object[] parameters = paramsExtractor.apply(entity);
//
//            for (int i = 0; i < parameters.length; i++) {
//                preparedStatement.setObject(i+1, parameters[i]);
//            }
//
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected >= 1) {
//                final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//                if(generatedKeys.next()) {
//                    entityId = generatedKeys.getInt(1);
//                }
//            }
//        } catch (SQLException e) {
//            LOGGER.error("can't save entity into DB due to error, cause: " + e.getMessage());
//        }
//
//        return entityId;
//    }




//    public <T> Optional<T> findByQuery(String queryName, Function<T, Object[]> paramsExtractor, Mapper<T> entityMapper, T entity) {
//        Optional<T> result;
//
//        final String sqlQuery = SqlPropertiesHandler.getSqlQuery(queryName);
//        LOGGER.info(sqlQuery);
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
//
//            final Object[] parameters = paramsExtractor.apply(entity);
//
//            for (int i = 0; i < parameters.length; i++) {
//                preparedStatement.setObject(i+1, parameters[i]);
//            }
//
//            final ResultSet resultSet = preparedStatement.executeQuery();
//            result = entityMapper.mapRow(resultSet);
//        } catch (BeanMappingException | SQLException e) {
//            LOGGER.error("can't get entity from DB due to error, cause: " + e.getMessage());
//            result = Optional.empty();
//        }
//
//        return result;
//    }




//    public <T> List<T> findAll(String queryName, Function<T, Object[]> paramsExtractor, Mapper<T> entityMapper, T entity) {
//        List<T> result = new ArrayList<>();;
//
//        final String sqlQuery = SqlPropertiesHandler.getSqlQuery(queryName);
//        LOGGER.info(sqlQuery);
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
//
//            final Object[] parameters = paramsExtractor.apply(entity);
//
//            for (int i = 0; i < parameters.length; i++) {
//                preparedStatement.setObject(i+1, parameters[i]);
//            }
//
//            // result set in
//            final ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                final Optional<T> t = entityMapper.mapRow(resultSet);
//                final T t1 = t.orElseThrow(SQLException::new);
//                result.add(t1);
//            }
//            // out int, list, entity
//        } catch (BeanMappingException | SQLException e) {
//            LOGGER.error("can't get entity from DB due to error, cause: " + e.getMessage());
//            result = new ArrayList<>();
//        }
//
//        return result;
//    }

}
