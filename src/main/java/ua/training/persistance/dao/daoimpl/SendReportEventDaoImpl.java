package ua.training.persistance.dao.daoimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.beans.SendReportEvent;
import ua.training.persistance.dao.DataAccessException;
import ua.training.persistance.dao.ISendReportEventDao;
import ua.training.persistance.dao.util.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_SEND_REPORT_EVENT;

public class SendReportEventDaoImpl implements ISendReportEventDao {
    private static SendReportEventDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(SendReportEventDaoImpl.class);

    public void setDataSource(MyDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private SendReportEventDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static SendReportEventDaoImpl getInstance() {
        if (instance == null) {
            instance = new SendReportEventDaoImpl();
        }
        return instance;
    }

    @Override
    public Long save(SendReportEvent bean) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_SEND_REPORT_EVENT);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Object[] params = {bean.getTimestamp(), bean.getReportStateId(), bean.getReportId(), bean.getSenderId()};

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            logger.debug("exp here _ 2");
            e.printStackTrace();
            // log
            throw new PersistenceException("", e);
        }
    }

    @Override
    public Long update(SendReportEvent bean) {
        return 0L;
    }

    @Override
    public boolean delete(SendReportEvent bean) {
        return false;
    }

    @Override
    public Optional<SendReportEvent> findById(Long id) {
        return Optional.empty();
    }
}
