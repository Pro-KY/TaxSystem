package ua.training.persistence.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.mappers.EntityMapper;
import ua.training.persistence.entities.Report;
import ua.training.persistence.entities.TaxType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportMapperImpl extends EntityMapper<Report> {
    private static final Logger logger = LogManager.getLogger(ReportMapperImpl.class);
    private static final String ID = "id";
    private static final String ID_IN_JOIN = "r_id";
    private static final String TAX_TYPE_ID = "tax_type_id";
    private static final String SUM = "sum";
    private static final String QUARTER = "quarter";

    private EntityMapper<TaxType> taxTypeMapper;
    private boolean mapTaxType;

    public ReportMapperImpl(boolean usedInJoin) {
        String idColumn = usedInJoin ? ID_IN_JOIN : ID;
        columnNames = new String[]{idColumn, TAX_TYPE_ID, SUM, QUARTER};
    }

    @Override
    public Report mapToEntity(ResultSet resultSet) {

        try {
                final long id = resultSet.getLong(columnNames[0]);
                final long taxTypeId = resultSet.getLong(columnNames[1]);
                final double sum = resultSet.getDouble(columnNames[2]);
                final int quarter = resultSet.getInt(columnNames[3]);

                mappedEntity = new Report(id, new TaxType(taxTypeId), sum, quarter);

                if(mapTaxType) {
                    mappedEntity.setTaxType(taxTypeMapper.mapToEntity(resultSet));
                }
//            }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }
        return mappedEntity;
    }


    public void mapTaxTypeRelation(EntityMapper<TaxType> taxTypeMapper) {
        this.mapTaxType = true;
        this.taxTypeMapper = taxTypeMapper;
    }

}
