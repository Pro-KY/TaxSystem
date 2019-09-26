package ua.training.persistance.dao.impl;

import ua.training.persistance.dao.IReportStateDao;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.beans.ReportState;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.Optional;

import static ua.training.util.handler.properties.SqlPropertiesHandler.REPORT_STATE_BY_NANE;

public class ReportStateDaoImpl implements IReportStateDao {
    private static ReportStateDaoImpl instance;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(MyDataSource myDataSource) {
        jdbcTemplate.setDataSource(myDataSource);
    }

    private ReportStateDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static ReportStateDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReportStateDaoImpl();
        }
        return instance;
    }

    public ReportState findByName(String name) {
        String sql = SqlPropertiesHandler.getSqlQuery(REPORT_STATE_BY_NANE);
//        jdbcTemplate.findByQuery(sql, );
        return null;
    }

    @Override
    public Long save(ReportState bean) {
        return 0L;
    }

    @Override
    public Long update(ReportState bean) {
        return 0L;
    }

    @Override
    public boolean delete(ReportState bean) {
        return false;
    }

    @Override
    public Optional<ReportState> findById(Long id) {
        return Optional.empty();
    }
}
