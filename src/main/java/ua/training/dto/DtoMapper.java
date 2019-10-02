package ua.training.dto;

import ua.training.persistence.entities.Report;
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

    public ReportDetailsDto mapToReportDetailsDto(ReportApproval reportApproval) {
        Long reportApprovalId = reportApproval.getId();
        Report report = reportApproval.getReport();
        String refusalCause = reportApproval.getRefusalCause();
        String approvalState = reportApproval.getStateApproval().getState();

        String inspectorName = null;
        Long inspectorId = null;

        final User inspector = reportApproval.getInspector();

        if(inspector != null) {
            inspectorName = inspector.getFirstName() + " " + inspector.getLastName();
            inspectorId = inspector.getId();
        }

        return new ReportDetailsDto.Builder()
                .reportApprovalId(reportApprovalId)
                .report(report)
                .refusalCause(refusalCause)
                .approvalState(approvalState)
                .inspectorName(inspectorName)
                .inspectorId(inspectorId)
                .build();
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
