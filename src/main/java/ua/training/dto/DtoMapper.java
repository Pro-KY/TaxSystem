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
        Long approvalStateId = reportApproval.getStateApproval().getId();

        String inspectorName = null;
        Long inspectorId = null;

        final User inspector = reportApproval.getInspector();

        if(inspector != null && inspector.getId() > 0) {
            inspectorName = inspector.getFirstName() + " " + inspector.getLastName();
            inspectorId = inspector.getId();
        }

        return new ReportDetailsDto.Builder()
                .reportApprovalId(reportApprovalId)
                .report(report)
                .refusalCause(refusalCause)
                .approvalStateId(approvalStateId)
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

    public ReportDto mapToReportDto(Report report) {
        final long reportId = report.getId();
        final double sum = report.getSum();
        final long quarter = report.getQuarter();
        final long taxTypeId = report.getTaxType().getId();

        return new ReportDto(reportId, taxTypeId, quarter, sum);
    }
}
