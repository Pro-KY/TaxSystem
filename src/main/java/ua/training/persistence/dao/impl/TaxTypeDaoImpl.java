package ua.training.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.ITaxTypeDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.TaxTypeMapperIml;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.TaxType;
import ua.training.util.properties.SqlProperties;

import java.util.List;
import java.util.Optional;

import static ua.training.util.properties.SqlProperties.*;

public class TaxTypeDaoImpl implements ITaxTypeDao {
    private static TaxTypeDaoImpl instance;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(TaxTypeDaoImpl.class);

    public void setDataSource(MysqlDataSource mysqlDataSource) {
        jdbcTemplate.setDataSource(mysqlDataSource);
    }

    private TaxTypeDaoImpl() {
        jdbcTemplate = JdbcTemplate.getInstance();
    }

    public static TaxTypeDaoImpl getInstance() {
        if (instance == null) {
            instance = new TaxTypeDaoImpl();
        }
        return instance;
    }

    @Override
    public Optional<TaxType> getTaxTypeByType(TaxType taxType) {
        String sql = SqlProperties.getSqlQuery(FIND_TAX_TYPE_BY_NAME);
        final String type = taxType.getType();
        final Object[] parameters = {type};
        return jdbcTemplate.findByQuery(sql, new TaxTypeMapperIml(false), parameters);
    }

    @Override
    public List<TaxType> getAllTaxTypes() {
        final Object[] parameters = {};
        String sql = SqlProperties.getSqlQuery(FIND_ALL_TAX_TYPES);
        return jdbcTemplate.finAll(sql, new TaxTypeMapperIml(false), parameters);
    }

    @Override
    public Long save(TaxType entity) {
        String sql = SqlProperties.getSqlQuery(SAVE_TAX_TYPE);
        return jdbcTemplate.saveOrUpdate(sql, entity.getType());
    }

    @Override
    public Long update(TaxType entity) {
        String sql = SqlProperties.getSqlQuery(UPDATE_TAX_TYPE);
        return jdbcTemplate.saveOrUpdate(sql, entity.getType(), entity.getId());
    }

    @Override
    public boolean delete(TaxType entity) {
        String sql = SqlProperties.getSqlQuery(DELETE_TAX_TYPE);
        return jdbcTemplate.delete(sql, entity.getId());
    }

    @Override
    public Optional<TaxType> findById(Long id) {
        String sql = SqlProperties.getSqlQuery(SqlProperties.FIND_INSPECTOR_CHANGING_BY_ID);
        final TaxTypeMapperIml taxTypeMapperIml = new TaxTypeMapperIml(false);
        return jdbcTemplate.findByQuery(sql, taxTypeMapperIml, id);
    }
}
