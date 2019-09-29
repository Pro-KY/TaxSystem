package ua.training.persistance.dao.mappers.impl;

import ua.training.persistance.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ChangeInspectorMapper extends EnitityMapper<ChangeInspector> {
    private static final String ID = "id";
    private static final String TIMESTAMP = "timestamp";
    private static final String REPORT_APPROVAL_ID = "report_approval_id";
    private static final String PREVIOUS_INPSPECTOR_ID = "previous_inspector_id";

    private EnitityMapper<User> userMapper;
    private EnitityMapper<ReportApproval> reportApprovalMapper;

    private boolean mapPreviousInspector;
    private boolean mapReportApprovalMapper;

    public ChangeInspectorMapper(ResultSet resultSet) {
        super(resultSet);
        columnsIndexes.put(ID, 1);
        columnsIndexes.put(TIMESTAMP, 2);
        columnsIndexes.put(REPORT_APPROVAL_ID, 3);
        columnsIndexes.put(PREVIOUS_INPSPECTOR_ID, 4);
    }

    @Override
    public ChangeInspector mapToEntity(ResultSet resultSet) {
        try {
                final long id = resultSet.getLong(columnsIndexes.get(ID));
                final Timestamp timestamp = resultSet.getTimestamp(columnsIndexes.get(TIMESTAMP));
                final Long reportApprovalId = resultSet.getLong(columnsIndexes.get(REPORT_APPROVAL_ID));
                final Long previousInspectorId = resultSet.getLong(columnsIndexes.get(PREVIOUS_INPSPECTOR_ID));

                final ReportApproval reportApproval = new ReportApproval(reportApprovalId);
                final User previousInspector = new User(reportApprovalId);

                mappedEntity = new ChangeInspector(id, timestamp, reportApproval, previousInspector);

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

    public void setUserMapper(EnitityMapper<User> userMapper) {
        mapPreviousInspector = true;
        this.userMapper = userMapper;
    }

    public void setReportApprovalMapper(EnitityMapper<ReportApproval> reportApprovalMapper) {
        mapReportApprovalMapper = true;
        this.reportApprovalMapper = reportApprovalMapper;
    }
}
