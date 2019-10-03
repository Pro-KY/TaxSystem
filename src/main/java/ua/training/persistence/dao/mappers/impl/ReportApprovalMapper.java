package ua.training.persistence.dao.mappers.impl;

import ua.training.persistence.dao.mappers.EntityMapper;
import ua.training.persistence.entities.Report;
import ua.training.persistence.entities.ReportApproval;
import ua.training.persistence.entities.StateApproval;
import ua.training.persistence.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReportApprovalMapper extends EntityMapper<ReportApproval> {
    private static final String ID = "id";
    private static final String ID_IN_JOIN = "ra_id";
    private static final String TIMESTAMP = "timestamp";
    private static final String REFUSAL_CAUSE = "refusal_cause";
    private static final String REPORT_ID  = "report_id";
    private static final String STATE_APPROVAL_ID = "state_approval_id";
    private static final String INSPECTOR_ID = "inspector_id";
    private static final String USER_ID = "user_id";

    private EntityMapper<Report> reportMapper;
    private EntityMapper<StateApproval> stateApprovalMapper;
    private EntityMapper<User> userMapper;
    private EntityMapper<User> inspectorMapper;

    private boolean mapReport;
    private boolean mapStateApproval;
    private boolean mapUser;
    private boolean mapInspector;

    public ReportApprovalMapper(boolean useInJoin) {
        String idColumn = useInJoin ? ID_IN_JOIN : ID;
        columnNames = new String[]{idColumn, TIMESTAMP, REFUSAL_CAUSE, STATE_APPROVAL_ID, REPORT_ID, USER_ID, INSPECTOR_ID};
    }

    @Override
    public ReportApproval mapToEntity(ResultSet resultSet) {
        try {

                final long id = resultSet.getLong(columnNames[0]);
                final Timestamp timestamp = resultSet.getTimestamp(columnNames[1]);
                final String refusalCause = resultSet.getString(columnNames[2]);
                final Long stateApprovalId = resultSet.getLong(columnNames[3]);
                final Long reportId = resultSet.getLong(columnNames[4]);
                final Long userId = resultSet.getLong(columnNames[5]);
                final Long inspectorId = resultSet.getLong(columnNames[6]);

                final Report report = new Report(reportId);
                final StateApproval stateApproval = new StateApproval(stateApprovalId);
                final User inspector = new User(inspectorId);
                final User user = new User(userId);
                mappedEntity = new ReportApproval(id, timestamp, refusalCause, stateApproval, report, user, inspector);

                if(mapReport) {
                    mappedEntity.setReport(reportMapper.mapToEntity(resultSet));
                }

                if(mapStateApproval) {
                    mappedEntity.setStateApproval(stateApprovalMapper.mapToEntity(resultSet));
                }

                if (mapInspector) {
                    mappedEntity.setInspector(inspectorMapper.mapToEntity(resultSet));
                }

                if (mapUser) {
                    mappedEntity.setUser(userMapper.mapToEntity(resultSet));
                }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }

        return mappedEntity;
    }

    public void mapStateApprovalRelation(EntityMapper<StateApproval> stateApprovalMapper) {
        this.stateApprovalMapper = stateApprovalMapper;
        mapStateApproval = true;
    }

    public void mapReportRelation(EntityMapper<Report> reportMapper) {
        this.reportMapper = reportMapper;
        mapReport = true;
    }

    public void mapUserRelation(EntityMapper<User> userMapper) {
        this.userMapper = userMapper;
        mapUser = true;
    }

    public void mapInspectorRelation(EntityMapper<User> inspectorMapper) {
        this.inspectorMapper = inspectorMapper;
        mapInspector = true;
    }
}
