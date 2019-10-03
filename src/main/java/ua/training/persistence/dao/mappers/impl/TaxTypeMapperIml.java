package ua.training.persistence.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.mappers.EntityMapper;
import ua.training.persistence.entities.TaxType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxTypeMapperIml extends EntityMapper<TaxType> {
    private static final Logger LOGGER = LogManager.getLogger(TaxTypeMapperIml.class);

    private static final String ID = "id";
    private static final String ID_IN_JOIN = "tp_id";
    private static final String TYPE = "type";

    public TaxTypeMapperIml(boolean usedInJoin) {
        String idColumn = usedInJoin ? ID_IN_JOIN : ID;
        columnNames = new String[]{idColumn, TYPE};
    }

    @Override
    public TaxType mapToEntity(ResultSet resultSet) {

        try {
            final long id = resultSet.getLong(columnNames[0]);
            final String type = resultSet.getString(columnNames[1]);

            mappedEntity = new TaxType(id, type);
        } catch (SQLException e) {
            LOGGER.error("can't map TaxType mappedEntity");
        }

        return mappedEntity;
    }
}
