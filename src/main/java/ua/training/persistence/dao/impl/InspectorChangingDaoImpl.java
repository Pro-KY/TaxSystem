package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IInspectorChangingDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.InspectorChangingMapper;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.InspectorChanging;
import ua.training.util.properties.SqlProperties;

import java.util.Optional;

import static ua.training.util.properties.SqlProperties.*;

public class InspectorChangingDaoImpl implements IInspectorChangingDao {
    private JdbcTemplate jdbcTemplate;
    private static InspectorChangingDaoImpl instance;
    private static final Logger log = LogManager.getLogger(InspectorChangingDaoImpl.class);

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
        String sql = SqlProperties.getSqlQuery(SAVE_INSPECTOR_CHANGING);

        Object[] parameters = {
                entity.getTimestamp(),
                entity.getReportApproval().getId(),
                entity.getPreviousInspector().getId()
        };

        return jdbcTemplate.saveOrUpdate(sql, parameters);
    }

    @Override
    public Long update(InspectorChanging entity) {
        String sql = SqlProperties.getSqlQuery(UPDATE_INSPECTOR_CHANGING_BY_ID);
        Object[] parameters = {
                entity.getTimestamp(),
                entity.getReportApproval().getId(),
                entity.getPreviousInspector().getId(),
                entity.getId()
        };

        return jdbcTemplate.saveOrUpdate(sql, parameters);
    }

    @Override
    public boolean delete(InspectorChanging entity) {
        String sql = SqlProperties.getSqlQuery(DELETE_INSPECTOR_CHANGING_BY_ID);
        return jdbcTemplate.delete(sql, entity.getId());
    }

    @Override
    public Optional<InspectorChanging> findById(Long id) {
        String sql = SqlProperties.getSqlQuery(SqlProperties.FIND_INSPECTOR_CHANGING_BY_ID);
        final InspectorChangingMapper reportApprovalMapper = new InspectorChangingMapper(false);
        return jdbcTemplate.findByQuery(sql, reportApprovalMapper, id);
    }
}
