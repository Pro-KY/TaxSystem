package ua.training.persistance.dao.impl;

import ua.training.persistance.dao.ITaxTypeDao;
import ua.training.persistance.dao.mappers.TaxTypeBeanMapperIml;
import ua.training.persistance.dao.jdbc.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.beans.TaxType;
import ua.training.util.handler.properties.SqlPropertiesHandler;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static ua.training.util.handler.properties.SqlPropertiesHandler.ALL_TAX_TYPES;
import static ua.training.util.handler.properties.SqlPropertiesHandler.GET_TAX_TYPE_BY_NAME;

public class TaxTypeDaoImpl implements ITaxTypeDao {
    private static TaxTypeDaoImpl instance;
//    private MyDataSource myDataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(MyDataSource myDataSource) {
//        this.myDataSource = myDataSource;
        jdbcTemplate.setDataSource(myDataSource);
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
        String sql = SqlPropertiesHandler.getSqlQuery(GET_TAX_TYPE_BY_NAME);
        final String type = taxType.getType();
        final Object[] parameters = {type};

        return jdbcTemplate.findByQuery(sql, new TaxTypeBeanMapperIml(), parameters);
    }

    @Override
    public List<TaxType> getAllTaxTypes() {
        final Object[] parameters = {};
        String sql = SqlPropertiesHandler.getSqlQuery(ALL_TAX_TYPES);
        return jdbcTemplate.finAll(sql, new TaxTypeBeanMapperIml(), parameters);
    }

    @Override
    public Long save(TaxType bean) {
        return null;
    }

    @Override
    public Long update(TaxType bean) {
        return null;
    }

    @Override
    public boolean delete(TaxType bean) {
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
