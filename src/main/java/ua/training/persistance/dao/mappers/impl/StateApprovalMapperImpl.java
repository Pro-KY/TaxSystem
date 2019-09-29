package ua.training.persistance.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.entities.StateApproval;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateApprovalMapperImpl extends EnitityMapper<StateApproval> {
    private static final Logger logger = LogManager.getLogger(StateApprovalMapperImpl.class);
    private static final String ID = "id";
    private static final String STATE = "state";

    public StateApprovalMapperImpl() {
        columnsIndexes.put(ID, 1);
        columnsIndexes.put(STATE, 2);
    }

    @Override
    public StateApproval mapToEntity(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                final Long id = resultSet.getLong(columnsIndexes.get(ID));
                final String state = resultSet.getString(columnsIndexes.get(STATE));
                mappedEntity = new StateApproval(id, state);
            }
        } catch (SQLException e) {
            logger.debug((e.getCause().toString()));
        }

        return mappedEntity;
    }
}
