package ua.training.persistance.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.beans.UserSentReportEvent;
import ua.training.persistance.dao.IUserSentReportEvent;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_USER_SEND_REPORT_EVENT;

public class UserSentReportEventImpl implements IUserSentReportEvent {
    private static UserSentReportEventImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(UserSentReportEventImpl.class);

    public void setDataSource(MyDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private UserSentReportEventImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static UserSentReportEventImpl getInstance() {
        if (instance == null) {
            instance = new UserSentReportEventImpl();
        }
        return instance;
    }

    @Override
    public Long save(UserSentReportEvent bean) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_USER_SEND_REPORT_EVENT);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Object[] params = {bean.getSendReportEventId(), bean.getUserId()};

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            logger.debug("exp here _ 1");
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public Long update(UserSentReportEvent bean) {
        return 0L;
    }

    @Override
    public boolean delete(UserSentReportEvent bean) {
        return false;
    }

    @Override
    public Optional<UserSentReportEvent> findById(Long id) {
        return Optional.empty();
    }
}
