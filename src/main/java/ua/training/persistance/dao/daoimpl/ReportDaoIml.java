package ua.training.persistance.dao.daoimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.beans.Report;
import ua.training.persistance.dao.DataAccessException;
import ua.training.persistance.dao.IReportDao;
import ua.training.persistance.dao.util.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_REPORT;

public class ReportDaoIml implements IReportDao {
    private static ReportDaoIml instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(ReportDaoIml.class);

    public void setDataSource(MyDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private ReportDaoIml() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static ReportDaoIml getInstance() {
        if (instance == null) {
            instance = new ReportDaoIml();
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
