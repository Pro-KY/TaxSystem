package ua.training.persistence.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.entities.TaxType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxTypeMapperIml extends EnitityMapper<TaxType> {
    private static final Logger LOGGER = LogManager.getLogger(TaxTypeMapperIml.class);

    private static final String ID = "id";
    private static final String TYPE = "type";

    public TaxTypeMapperIml() {
        columnsIndexes.put(ID, 1);
        columnsIndexes.put(TYPE, 2);
    }

    public TaxTypeMapperIml(int[] indexes) {
        setIndexesInJoinQuery(indexes);
    }

    @Override
    public TaxType mapToEntity(ResultSet resultSet) {

        try {
            final long id = resultSet.getLong(columnsIndexes.get(ID));
            final String type = resultSet.getString(columnsIndexes.get(TYPE));

            mappedEntity = new TaxType(id, type);
        } catch (SQLException e) {
            LOGGER.error("can't map TaxType mappedEntity");
        }

        return mappedEntity;
    }
}
