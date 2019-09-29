package ua.training.persistance.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.mappers.EnitityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxTypeEnitityMapperIml implements EnitityMapper<TaxType> {
    private static final Logger LOGGER = LogManager.getLogger(TaxTypeEnitityMapperIml.class);

    private static final String ID = "id";
    private static final String TYPE = "type";

    @Override
    public TaxType mapRow(ResultSet resultSet) {
        TaxType taxType = null;

        try {
            final long id = resultSet.getLong(ID);
            final String type = resultSet.getString(TYPE);

            return new TaxType(id, type);
        } catch (SQLException e) {
            LOGGER.error("can't map TaxType entity");
        }

        return taxType;
    }
}
