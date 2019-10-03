package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IReportDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.ReportMapperImpl;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.Report;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.FIND_REPORT_BY_ID;
import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_REPORT;

public class ReportDaoImpl implements IReportDao {
    private static ReportDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(ReportDaoImpl.class);

    public void setDataSource(MysqlDataSource dataSource) {
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
    public Long save(Report report) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_REPORT);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Object[] params = {report.getTaxType().getId(), report.getSum(), report.getQuarter()};

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
        String sql = SqlPropertiesHandler.getSqlQuery(FIND_REPORT_BY_ID);
        return jdbcTemplate.findByQuery(sql, new ReportMapperImpl(false), id);
    }
}
