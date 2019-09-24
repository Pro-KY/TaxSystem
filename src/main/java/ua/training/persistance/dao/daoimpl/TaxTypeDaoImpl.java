package ua.training.persistance.dao.daoimpl;

import ua.training.persistance.dao.ITaxTypeDao;
import ua.training.persistance.dao.mappers.TaxTypeMapperIml;
import ua.training.persistance.dao.util.JdbcTemplate;
import ua.training.persistance.db.datasource.MyDataSource;
import ua.training.persistance.entities.TaxType;
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

        return jdbcTemplate.getEntity(sql, new TaxTypeMapperIml(), parameters);
    }

    @Override
    public List<TaxType> getAllTaxTypes() {
        final Object[] parameters = {};
        String sql = SqlPropertiesHandler.getSqlQuery(ALL_TAX_TYPES);
        return jdbcTemplate.getAllEntities(sql, new TaxTypeMapperIml(), parameters);
    }

    @Override
    public void save(TaxType entity) {

    }

    @Override
    public void update(TaxType entity){


    }

    @Override
    public void delete(TaxType entity){

    }

    @Override
    public Optional<TaxType> getById(Long id) {
        return Optional.empty();
    }

    private Function<TaxType, Object[]> paramsSupplier = taxType -> {
        final String type = taxType.getType();
        return new Object[] {type};
    };
}
