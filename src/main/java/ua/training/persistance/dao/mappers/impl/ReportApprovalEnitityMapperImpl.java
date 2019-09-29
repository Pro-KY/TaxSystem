package ua.training.persistance.dao.mappers.impl;

import ua.training.persistance.dao.mappers.EnitityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReportApprovalEnitityMapperImpl implements EnitityMapper<ReportApproval> {
    private static final String ID = "id";
    private static final String TIMESTAMP = "timestamp";
    private static final String REFUSAL_CAUSE = "refusal_cause";
    private static final String REPORT_ID  = "report_id";
    private static final String STATE_APPROVAL_ID = "state_approval_id";
    private static final String INSPECTOR_ID = "inspector_id";
    private static final String USER_ID = "user_id";


    @Override
    public ReportApproval mapRow(ResultSet resultSet) {
        ReportApproval reportApproval = null;

        try {
            if (resultSet.next()) {
                final long id = resultSet.getLong(ID);
                final Timestamp timestamp = resultSet.getTimestamp(TIMESTAMP);
                final String refusalCause = resultSet.getString(REFUSAL_CAUSE);
                final Long reportId = resultSet.getLong(REPORT_ID);
                final Long stateApprovalId = resultSet.getLong(STATE_APPROVAL_ID);
                final Long inspectorId = resultSet.getLong(INSPECTOR_ID);
                final Long userId = resultSet.getLong(USER_ID);

                reportApproval = new ReportApproval(id, timestamp, refusalCause, reportId, stateApprovalId, inspectorId, userId);
            }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }

        return reportApproval;
    }

}
