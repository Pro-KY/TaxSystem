package ua.training.persistance.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.util.exceptions.DataAccessException;
import ua.training.persistance.dao.IReportDao;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_REPORT;

public class ReportDaoImpl implements IReportDao {
    private static ReportDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(ReportDaoImpl.class);

    public void setDataSource(MyDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private ReportDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static ReportDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReportDaoImpl();
        }
        return instance;
    }

    @Override
    public Long save(Report bean) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_REPORT);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Object[] params = {bean.getTaxTypeId(), bean.getSum(), bean.getQuarter()};

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            logger.debug("exp here _ 1");
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public Long update(Report bean) {
        return 0L;
    }

    @Override
    public boolean delete(Report bean) {
        return false;
    }

    @Override
    public Optional<Report> findById(Long id) {
        return Optional.empty();
    }
}
