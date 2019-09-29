package ua.training.persistance.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.mappers.EnitityMapper;
import ua.training.persistance.entities.Report;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportEntityMapperImpl implements EnitityMapper<Report> {
    private static final Logger logger = LogManager.getLogger(ReportEntityMapperImpl.class);

    private static final String ID = "id";
    private static final String SUM = "sum";
    private static final String QUARTER = "quarter";

    @Override
    public Report mapRow(ResultSet resultSet) {
        Report report = null;

        try {
            if (resultSet.next()) {
                final long id = resultSet.getLong(ID);
                final double sum = resultSet.getDouble(SUM);
                final int quarter = resultSet.getInt(QUARTER);
                report = new Report(id, sum, quarter);
            }
        } catch (SQLException e) {
            logger.debug(e.getCause().toString());
        }

        return report;
    }
}
