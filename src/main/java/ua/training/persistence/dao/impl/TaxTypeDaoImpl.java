package ua.training.persistence.dao.impl;

import ua.training.persistence.dao.ITaxTypeDao;
import ua.training.persistence.dao.jdbc.JdbcTemplate;
import ua.training.persistence.dao.mappers.impl.TaxTypeMapperIml;
import ua.training.persistence.db.datasource.MysqlDataSource;
import ua.training.persistence.entities.TaxType;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static ua.training.util.handler.properties.SqlPropertiesHandler.FIND_ALL_TAX_TYPES;
import static ua.training.util.handler.properties.SqlPropertiesHandler.FIND_TAX_TYPE_BY_NAME;

public class TaxTypeDaoImpl implements ITaxTypeDao {
    private static TaxTypeDaoImpl instance;
//    private MysqlDataSource myDataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(MysqlDataSource mysqlDataSource) {
//        this.mysqlDataSource = mysqlDataSource;
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
        String sql = SqlPropertiesHandler.getSqlQuery(FIND_TAX_TYPE_BY_NAME);
        final String type = taxType.getType();
        final Object[] parameters = {type};

        return jdbcTemplate.findByQuery(sql, new TaxTypeMapperIml(false), parameters);
    }

    @Override
    public List<TaxType> getAllTaxTypes() {
        final Object[] parameters = {};
        String sql = SqlPropertiesHandler.getSqlQuery(FIND_ALL_TAX_TYPES);
        return jdbcTemplate.finAll(sql, new TaxTypeMapperIml(false), parameters);
    }

    @Override
    public Long save(TaxType entity) {
        return null;
    }

    @Override
    public Long update(TaxType entity) {
        return null;
    }

    @Override
    public boolean delete(TaxType entity) {
        return false;
    }

    @Override
    public Optional<TaxType> findById(Long id) {
        return Optional.empty();
    }

    private Function<TaxType, Object[]> paramsSupplier = taxType -> {
        final String type = taxType.getType();
        return new Object[] {type};
    };
}
