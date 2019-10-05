package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IInspectorChangingDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.InspectorChanging;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_INSPECTOR_CHANGING;

public class InspectorChangingDaoImpl implements IInspectorChangingDao {
    private JdbcTemplate jdbcTemplate;
    private static InspectorChangingDaoImpl instance;
    private static final Logger log = LogManager.getLogger(ReportApprovalDaoImpl.class);

    public void setDataSource(MysqlDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private InspectorChangingDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static InspectorChangingDaoImpl getInstance() {
        if (instance == null) {
            instance = new InspectorChangingDaoImpl();
        }
        return instance;
    }

    @Override
    public Long save(InspectorChanging entity) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_INSPECTOR_CHANGING);

        Object[] parameters = {
                entity.getDate(),
                entity.getReportApproval().getId(),
                entity.getPreviousInspector().getId()
        };

        try {
            return jdbcTemplate.saveOrUpdate(sql, parameters);
        } catch (DataAccessException e) {
            log.debug(e.getMessage(), e.getCause());
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public Long update(InspectorChanging entity) {
        return null;
    }

    @Override
    public boolean delete(InspectorChanging entity) {
        return false;
    }

    @Override
    public Optional<InspectorChanging> findById(Long id) {
        return Optional.empty();
    }
}
