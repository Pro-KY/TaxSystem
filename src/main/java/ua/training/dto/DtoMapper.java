package ua.training.dto;

import ua.training.persistence.entities.ReportApproval;
import ua.training.persistence.entities.StateApproval;
import ua.training.persistence.entities.User;

import java.sql.Timestamp;

public class DtoMapper {
    private static DtoMapper instance;

    private DtoMapper() {}

    public static DtoMapper getInstance() {
        if (instance == null) {
            instance = new DtoMapper();
        }
        return instance;
    }

    public SentReportsDto mapToSentReportsDto(ReportApproval reportApproval) {
        final StateApproval stateApproval = reportApproval.getStateApproval();
        final long reportId = reportApproval.getReport().getId();
        final long reportApprovalId = reportApproval.getId();
        final String state = stateApproval.getState();
        final Timestamp timestamp = reportApproval.getTimestamp();
        final User inspector = reportApproval.getInspector();
        final String  inspectorName = inspector.getFirstName() + " " +inspector.getLastName();
        return new SentReportsDto(reportId, state, inspectorName, timestamp, reportApprovalId);
    }
}
