package ua.training.persistence.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistence.dao.mappers.EntityMapper;
import ua.training.persistence.entities.StateApproval;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateApprovalMapperImpl extends EntityMapper<StateApproval> {
    private static final Logger logger = LogManager.getLogger(StateApprovalMapperImpl.class);
    private static final String ID = "id";
    private static final String ID_IN_JOIN = "sa_id";
    private static final String STATE = "state";


    public StateApprovalMapperImpl(boolean usedInJoin) {
        String idColumn = usedInJoin ? ID_IN_JOIN : ID;
        columnNames = new String[]{idColumn, STATE};
    }

    @Override
    public StateApproval mapToEntity(ResultSet resultSet) {
        try {
                final Long id = resultSet.getLong(columnNames[0]);
                final String state = resultSet.getString(columnNames[1]);
                mappedEntity = new StateApproval(id, state);
        } catch (SQLException e) {
            logger.debug((e.getCause().toString()));
        }

        return mappedEntity;
    }
}
