package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IReportApprovalDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.*;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.ReportApproval;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.List;
import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_REPORT_APPROVAL;

public class ReportApprovalDaoImpl implements IReportApprovalDao {
    private static ReportApprovalDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger log = LogManager.getLogger(ReportApprovalDaoImpl.class);

    public void setDataSource(MysqlDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private ReportApprovalDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static ReportApprovalDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReportApprovalDaoImpl();
        }
        return instance;
    }

    @Override
    public Long save(ReportApproval entity) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_REPORT_APPROVAL);
        Object[] params = {
                entity.getTimestamp(),
                entity.getStateApproval().getId(),
                entity.getUser().getId(),
                entity.getReport().getId()
        };

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            log.debug("exp here_2");
            e.printStackTrace();
            // log
            throw new PersistenceException("", e);
        }
    }

    public long countAllRowsForUserById(Long userId) {
        return jdbcTemplate.countRows(SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.REPORT_APPROVAL_COUNT_FOR_USER), userId);
    }

    @Override
    public List<ReportApproval> getReportApprovalListByUserId(long pageSize, long offSet, long userId) {
        String sql = SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.REPORT_APPROVAL_FOR_USER);

        final ReportApprovalMapper reportApprovalMapper = new ReportApprovalMapper(true);
        reportApprovalMapper.mapStateApprovalRelation(new StateApprovalMapperImpl(true));
        reportApprovalMapper.mapInspectorRelation(new UserMapperImpl(true, true));

        return jdbcTemplate.finAll(sql, reportApprovalMapper, userId, pageSize, offSet);
    }

    @Override
    public Long update(ReportApproval entity) {
        String sql = SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.UPDATE_REPORT_APPROVAL_BY_ID);
        Object[] params = {
                entity.getTimestamp(),
                entity.getRefusalCause(),
                entity.getStateApproval().getId(),
                entity.getReport().getId(),
                entity.getUser().getId(),
                entity.getInspector() != null && entity.getInspector().getId() > 0 ? entity.getInspector().getId() : null,
                entity.getId()
        };

        return jdbcTemplate.saveOrUpdate(sql, params);
    }

    @Override
    public boolean delete(ReportApproval entity) {
        return false;
    }

    public Optional<ReportApproval> findByIdJoinReportJoinInspector(Long id) {
        String sql = SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.REPORT_APPROVAL_JOIN_REPORT_JOIN_INSPECTOR);

        final ReportApprovalMapper reportApprovalMapper = new ReportApprovalMapper(true);

        final ReportMapperImpl reportMapper = new ReportMapperImpl(true);
        reportMapper.mapTaxTypeRelation(new TaxTypeMapperIml(true));
        reportApprovalMapper.mapReportRelation(reportMapper);
        reportApprovalMapper.mapStateApprovalRelation(new StateApprovalMapperImpl(true));
        reportApprovalMapper.mapInspectorRelation(new UserMapperImpl(true, true));

        return jdbcTemplate.findByQuery(sql, reportApprovalMapper, id);
    }

    public Optional<ReportApproval> findByIdJoinUser(Long id) {
        String sql = SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.REPORT_APPROVAL_JOIN_USER);
        final ReportApprovalMapper reportApprovalMapper = new ReportApprovalMapper(true);
        reportApprovalMapper.mapUserRelation(new UserMapperImpl(true, false));

        return jdbcTemplate.findByQuery(sql, reportApprovalMapper, id);
    }

    @Override
    public Optional<ReportApproval> findById(Long id) {
        String sql = SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.FIND_REPORT_APPROVAL_BY_ID);
        final ReportApprovalMapper reportApprovalMapper = new ReportApprovalMapper(false);
        return jdbcTemplate.findByQuery(sql, reportApprovalMapper, id);
    }
}
