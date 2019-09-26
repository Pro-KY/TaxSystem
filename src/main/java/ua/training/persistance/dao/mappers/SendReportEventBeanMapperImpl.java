package ua.training.persistance.dao.mappers;

import ua.training.persistance.beans.SendReportEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class SendReportEventBeanMapperImpl implements BeanMapper<SendReportEvent> {
    private static final String ID = "id";
    private static final String TIMESTAMP = "timestamp";
    private static final String REFUSAL_CAUSE = "refusal_cause";
    private static final String REPORT_STATE_ID = "report_state_id";
    private static final String REPORT_ID = "report_id";
    private static final String USER_ID = "user_id";
    private static final String INSPECTOR_ID = "inspector_id";


    @Override
    public SendReportEvent mapRow(ResultSet resultSet) {
        SendReportEvent sendReportEvent = null;

        try {
            if (resultSet.next()) {
                final Long id = resultSet.getLong(ID);
                final Timestamp email = resultSet.getTimestamp(TIMESTAMP);
                final String refusalCause = resultSet.getString(REFUSAL_CAUSE);
                final Long reportStateId = resultSet.getLong(REPORT_STATE_ID);
                final Long reportId = resultSet.getLong(REPORT_ID);
                final Long userId = resultSet.getLong(USER_ID);
                final Long inspectorId = resultSet.getLong(INSPECTOR_ID);
                sendReportEvent = new SendReportEvent(id, email, refusalCause, reportStateId, reportId, userId, inspectorId);
            }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
//            throw new BeanMappingException("can't map User bean due to absent of some fields", e.getCause());
            //TODO: add logger here
        }

        return sendReportEvent;
    }
}
