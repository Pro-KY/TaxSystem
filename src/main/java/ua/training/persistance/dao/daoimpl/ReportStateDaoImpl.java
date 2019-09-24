package ua.training.persistance.dao.daoimpl;

import ua.training.persistance.dao.IReportStateDao;
import ua.training.persistance.dao.util.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.entities.ReportState;
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
//        jdbcTemplate.getEntity(sql, );
        return null;
    }

    @Override
    public void save(ReportState entity) {

    }

    @Override
    public void update(ReportState entity) {

    }

    @Override
    public void delete(ReportState entity) {

    }

    @Override
    public Optional<ReportState> getById(Long id) {
        return Optional.empty();
    }
}
