package ua.training.persistence.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.entities.Report;
import ua.training.persistence.entities.TaxType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportMapperImpl extends EntityMapper<Report> {
    private static final Logger logger = LogManager.getLogger(ReportMapperImpl.class);
    private static final String ID = "id";
    private static final String TAX_TYPE_ID = "tax_type_id";
    private static final String SUM = "sum";
    private static final String QUARTER = "quarter";

    private EntityMapper<TaxType> taxTypeMapper;
    private boolean mapTaxType;

    public ReportMapperImpl() {
        columnsIndexes.put(ID, 1);
        columnsIndexes.put(TAX_TYPE_ID, 2);
        columnsIndexes.put(SUM, 3);
        columnsIndexes.put(QUARTER, 4);
    }

    @Override
    public Report mapToEntity(ResultSet resultSet) {

        try {
                final long id = resultSet.getLong(columnsIndexes.get(ID));
                final long taxTypeId = resultSet.getLong(columnsIndexes.get(TAX_TYPE_ID));
                final double sum = resultSet.getDouble(columnsIndexes.get(SUM));
                final int quarter = resultSet.getInt(columnsIndexes.get(QUARTER));

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


    public void setTaxTypeMapper(EntityMapper<TaxType> taxTypeMapper) {
        this.mapTaxType = true;
        this.taxTypeMapper = taxTypeMapper;
    }

}
