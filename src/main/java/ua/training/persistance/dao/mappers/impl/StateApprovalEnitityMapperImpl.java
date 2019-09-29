package ua.training.persistance.dao.mappers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.dao.mappers.EnitityMapper;
import ua.training.persistance.entities.StateApproval;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateApprovalEnitityMapperImpl implements EnitityMapper<StateApproval> {
    private static final Logger logger = LogManager.getLogger(StateApprovalEnitityMapperImpl.class);
    private static final String ID = "id";
    private static final String STATE = "state";

    @Override
    public StateApproval mapRow(ResultSet resultSet) {
        StateApproval stateApproval = null;

        try {
            if (resultSet.next()) {
                final Long id = resultSet.getLong(ID);
                final String state = resultSet.getString(STATE);
                stateApproval = new StateApproval(id, state);
            }
        } catch (SQLException e) {
            logger.debug((e.getCause().toString()));
        }

        return stateApproval;
    }
}
