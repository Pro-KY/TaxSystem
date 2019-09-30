package ua.training.persistance.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.IReportApprovalDao;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.dao.mappers.impl.ReportApprovalMapper;
import ua.training.persistance.dao.mappers.impl.StateApprovalMapperImpl;
import ua.training.persistance.dao.mappers.impl.UserMapperImpl;
import ua.training.persistance.db.datasource.MysqlDataSource;
import ua.training.persistance.entities.ReportApproval;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.List;
import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_REPORT_APPROVAL;

public class ReportApprovalDaoImpl implements IReportApprovalDao {
    private static ReportApprovalDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(ReportApprovalDaoImpl.class);

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
    public Long save(ReportApproval reportApproval) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_REPORT_APPROVAL);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Object[] params = {
                reportApproval.getTimestamp(),
                reportApproval.getStateApproval().getId(),
                reportApproval.getUser().getId(),
                reportApproval.getReport().getId()
        };

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            logger.debug("exp here_2");
            e.printStackTrace();
            // log
            throw new PersistenceException("", e);
        }
    }

    public long countAllRows() {
        return jdbcTemplate.countRows(SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.REPORT_APPROVAL_COUNT));
    }

    @Override
    public List<ReportApproval> getPaginationList(long pageSize, long offSet, long userId) { // pageSize, offset
        String sql = SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.REPORT_APPROVAL_PAGINATION);

        final ReportApprovalMapper reportApprovalMapper = new ReportApprovalMapper();

        final StateApprovalMapperImpl stateApprovalMapper = new StateApprovalMapperImpl();
        stateApprovalMapper.setIndexesInJoinQuery(new int[] {8, 9});
        reportApprovalMapper.setStateApprovalMapper(stateApprovalMapper);

        final UserMapperImpl userMapper = new UserMapperImpl();
        userMapper.setIndexesInJoinQuery(new int[] {10, 11, 12, 13, 14, 15, 16, 17});
        reportApprovalMapper.setInspectorMapper(userMapper);

        return jdbcTemplate.finAll(sql, reportApprovalMapper, userId, pageSize, offSet);
    }

    @Override
    public Long update(ReportApproval bean) {
        return 0L;
    }

    @Override
    public boolean delete(ReportApproval bean) {
        return false;
    }

    @Override
    public Optional<ReportApproval> findById(Long id) {
        return Optional.empty();
    }
}
