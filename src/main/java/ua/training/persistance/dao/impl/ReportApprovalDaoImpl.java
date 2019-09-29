package ua.training.persistance.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.PaginationDto;
import ua.training.dto.ReportApprovalDto;
import ua.training.persistance.dao.IReportApprovalDao;
import ua.training.persistance.dao.jdbc.JdbcPagination;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.util.exceptions.DataAccessException;
import ua.training.util.exceptions.PersistenceException;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.List;
import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.SAVE_SEND_REPORT_EVENT;

public class ReportApprovalDaoImpl implements IReportApprovalDao {
    private static ReportApprovalDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(ReportApprovalDaoImpl.class);

    public void setDataSource(MyDataSource dataSource) {
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
    public Long save(ReportApproval bean) {
        String sql = SqlPropertiesHandler.getSqlQuery(SAVE_SEND_REPORT_EVENT);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Object[] params = {bean.getTimestamp(), bean.getStateApprovalId(), bean.getReportId()};

        try {
            return jdbcTemplate.saveOrUpdate(sql, params);
        } catch (DataAccessException e) {
            logger.debug("exp here_2");
            e.printStackTrace();
            // log
            throw new PersistenceException("", e);
        }
    }

    @Override
    public List<ReportApprovalDto> getPaginationList(PaginationDto dto) {

        String sql = SqlPropertiesHandler.getSqlQuery(SqlPropertiesHandler.PAGINATION);
        JdbcPagination<ReportApproval> jdbcPagination = new JdbcPagination<>(jdbcTemplate);
        jdbcPagination.countAllRowsAmount(SqlPropertiesHandler.ALL_ROWS_PAGINATION_COUNT);

        final int pageSize = dto.getPageSize();
        jdbcPagination.setPageSize(pageSize);

//        Object[] params = {jdbcPagination.getPageSize(), jdbcPagination.getOffSet()};

//        final List<ReportApprovalDto> reportApprovals = jdbcPagination.getpageResult(sql,);
//        return reportApprovals;
        return null;
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
