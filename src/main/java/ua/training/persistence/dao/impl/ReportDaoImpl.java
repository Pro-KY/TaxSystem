package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.IReportDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.ReportMapperImpl;
import ua.training.persistence.dao.mappers.impl.TaxTypeMapperIml;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.Report;
import ua.training.util.properties.SqlProperties;

import java.util.Optional;

import static ua.training.util.properties.SqlProperties.*;

public class ReportDaoImpl implements IReportDao {
    private static ReportDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(ReportDaoImpl.class);

    public void setDataSource(MysqlDataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    private ReportDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static ReportDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReportDaoImpl();
        }
        return instance;
    }

    @Override
    public Long save(Report entity) {
        String sql = SqlProperties.getSqlQuery(SAVE_REPORT);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        return jdbcTemplate.saveOrUpdate(sql, entity.getTaxType().getId(), entity.getSum(), entity.getQuarter());

    }

    @Override
    public Long update(Report entity) {
        String sql = SqlProperties.getSqlQuery(UPDATE_REPORT_BY_ID);
        final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        return jdbcTemplate.saveOrUpdate(sql, entity.getTaxType().getId(), entity.getSum(), entity.getQuarter(), entity.getId());
    }

    @Override
    public boolean delete(Report entity) {
        String sql = SqlProperties.getSqlQuery(DELETE_REPORT_BY_ID);
        return jdbcTemplate.delete(sql, entity.getId());
    }

    @Override
    public Optional<Report> findById(Long id) {
        String sql = SqlProperties.getSqlQuery(FIND_REPORT_BY_ID);

        final ReportMapperImpl reportMapper = new ReportMapperImpl(false);
        reportMapper.mapTaxTypeRelation(new TaxTypeMapperIml(true));
        return jdbcTemplate.findByQuery(sql, reportMapper, id);
    }
}
