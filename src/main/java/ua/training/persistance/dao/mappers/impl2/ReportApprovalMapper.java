package ua.training.persistance.dao.mappers.impl2;

import ua.training.persistance.entities.Report;
import ua.training.persistance.entities.ReportApproval;
import ua.training.persistance.entities.StateApproval;
import ua.training.persistance.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReportApprovalMapper extends EnitityMapper<ReportApproval> {
    private static final String ID = "id";
    private static final String TIMESTAMP = "timestamp";
    private static final String REFUSAL_CAUSE = "refusal_cause";
    private static final String REPORT_ID  = "report_id";
    private static final String STATE_APPROVAL_ID = "state_approval_id";
    private static final String INSPECTOR_ID = "inspector_id";
    private static final String USER_ID = "user_id";

    private EnitityMapper<Report> reportMapper;
    private EnitityMapper<StateApproval> stateApprovalMapper;
    private EnitityMapper<User> userMapper;
    private EnitityMapper<User> inspectorMapper;

    private boolean mapReport;
    private boolean mapStateApproval;
    private boolean mapUser;
    private boolean mapInspector;

    public ReportApprovalMapper() {
        columnsIndexes.put(ID, 1);
        columnsIndexes.put(TIMESTAMP, 2);
        columnsIndexes.put(REFUSAL_CAUSE, 3);
        columnsIndexes.put(REPORT_ID, 3);
        columnsIndexes.put(STATE_APPROVAL_ID, 4);
        columnsIndexes.put(INSPECTOR_ID, 5);
        columnsIndexes.put(USER_ID, 6);
    }

    @Override
    public ReportApproval mapToEntity(ResultSet resultSet) {
        super.resultSet = resultSet;
        try {
            if (resultSet.next()) {
                final long id = resultSet.getLong(columnsIndexes.get(ID));
                final Timestamp timestamp = resultSet.getTimestamp(columnsIndexes.get(TIMESTAMP));
                final String refusalCause = resultSet.getString(columnsIndexes.get(REFUSAL_CAUSE));
                final Long reportId = resultSet.getLong(columnsIndexes.get(REPORT_ID));
                final Long stateApprovalId = resultSet.getLong(columnsIndexes.get(STATE_APPROVAL_ID));
                final Long inspectorId = resultSet.getLong(columnsIndexes.get(INSPECTOR_ID));
                final Long userId = resultSet.getLong(columnsIndexes.get(USER_ID));

                final Report report = new Report(reportId);
                final StateApproval stateApproval = new StateApproval(stateApprovalId);
                final User inspector = new User(inspectorId);
                final User user = new User(userId);
                mappedEntity = new ReportApproval(id, timestamp, refusalCause, stateApproval, report, inspector, user);

                if(mapReport) {
                    mappedEntity.setReport(reportMapper.mapToEntity(resultSet));
                }

                if(mapStateApproval) {
                    mappedEntity.setStateApproval(stateApprovalMapper.mapToEntity(resultSet));
                }

                if (mapInspector) {
                    mappedEntity.setUser(userMapper.mapToEntity(resultSet));
                }

                if (mapUser) {
                    mappedEntity.setUser(inspectorMapper.mapToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }

        return mappedEntity;
    }

    public void setStateApprovalMapper(EnitityMapper<StateApproval> stateApprovalMapper) {
        mapStateApproval = true;
        this.stateApprovalMapper = stateApprovalMapper;
    }

    public void setReportMapper(EnitityMapper<Report> reportMapper) {
        mapReport = true;
        this.reportMapper = reportMapper;
    }

    public void setUserMapper(EnitityMapper<User> userMapper) {
        mapUser = true;
        this.userMapper = userMapper;
    }

    public void setMapInspector(EnitityMapper<User> inspectorMapper) {
        mapInspector = true;
        this.inspectorMapper = inspectorMapper;
    }
}
