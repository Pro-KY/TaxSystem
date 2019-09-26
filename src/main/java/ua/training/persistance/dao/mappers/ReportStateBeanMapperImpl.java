package ua.training.persistance.dao.mappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.beans.ReportState;

import java.sql.ResultSet;

public class ReportStateBeanMapperImpl implements BeanMapper<ReportState> {
    private static final Logger LOGGER = LogManager.getLogger(TaxTypeBeanMapperIml.class);
    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    public ReportState mapRow(ResultSet resultSet) {
        return null;
    }
}
