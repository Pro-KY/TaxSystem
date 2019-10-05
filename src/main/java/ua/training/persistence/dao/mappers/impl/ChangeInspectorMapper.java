package ua.training.persistence.dao.mappers.impl;

import ua.training.persistence.dao.mappers.EntityMapper;
import ua.training.persistence.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ChangeInspectorMapper extends EntityMapper<InspectorChanging> {
    private static final String ID = "id";
    private static final String TIMESTAMP = "timestamp";
    private static final String REPORT_APPROVAL_ID = "report_approval_id";
    private static final String PREVIOUS_INPSPECTOR_ID = "previous_inspector_id";

    private EntityMapper<User> userMapper;
    private EntityMapper<ReportApproval> reportApprovalMapper;

    private boolean mapPreviousInspector;
    private boolean mapReportApprovalMapper;

    public ChangeInspectorMapper() {
        columnNames = new String[]{ID, TIMESTAMP, REPORT_APPROVAL_ID, PREVIOUS_INPSPECTOR_ID};
    }

    @Override
    public InspectorChanging mapToEntity(ResultSet resultSet) {
        try {
                final long id = resultSet.getLong(columnNames[0]);
                final Timestamp timestamp = resultSet.getTimestamp(columnNames[1]);
                final Long reportApprovalId = resultSet.getLong(columnNames[2]);
                final Long previousInspectorId = resultSet.getLong(columnNames[3]);

                final ReportApproval reportApproval = new ReportApproval(reportApprovalId);
                final User previousInspector = new User(reportApprovalId);

                mappedEntity = new InspectorChanging(id, timestamp, reportApproval, previousInspector);

                if(mapPreviousInspector) {
                    mappedEntity.setPreviousInspector(userMapper.mapToEntity(resultSet));
                }

                if(mapReportApprovalMapper) {
                    mappedEntity.setReportApproval(reportApprovalMapper.mapToEntity(resultSet));
                }
        } catch (SQLException e) {
            System.out.println(e.getCause().toString());
        }
        return mappedEntity;
    }

    public void setUserMapper(EntityMapper<User> userMapper) {
        mapPreviousInspector = true;
        this.userMapper = userMapper;
    }

    public void setReportApprovalMapper(EntityMapper<ReportApproval> reportApprovalMapper) {
        mapReportApprovalMapper = true;
        this.reportApprovalMapper = reportApprovalMapper;
    }
}
