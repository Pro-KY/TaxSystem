package ua.training.dto;

import ua.training.persistence.entities.Report;

public class ReportDetailsDto {
    private Long reportApprovalId;
    private Report report;
    private String refusalCause;
    private Long approvalStateId;
    private String inspectorName;
    private Long inspectorId;

    private ReportDetailsDto(Builder builder) {
        reportApprovalId = builder.reportApprovalId;
        report = builder.report;
        refusalCause = builder.refusalCause;
        approvalStateId = builder.approvalStateId;
        inspectorName = builder.inspectorName;
        inspectorId = builder.inspectorId;
    }

    public Long getReportApprovalId() {
        return reportApprovalId;
    }

    public Report getReport() {
        return report;
    }

    public String getRefusalCause() {
        return refusalCause;
    }

    public Long getApprovalStateId() {
        return approvalStateId;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public Long getInspectorId() {
        return inspectorId;
    }

    public static final class Builder {
        private Long reportApprovalId;
        private Report report;
        private String refusalCause;
        private Long approvalStateId;
        private String inspectorName;
        private Long inspectorId;

        public Builder() { }

        public Builder reportApprovalId(Long val) {
            reportApprovalId = val;
            return this;
        }

        public Builder report(Report val) {
            report = val;
            return this;
        }

        public Builder refusalCause(String val) {
            refusalCause = val;
            return this;
        }

        public Builder approvalStateId(Long val) {
            approvalStateId = val;
            return this;
        }

        public Builder inspectorName(String val) {
            inspectorName = val;
            return this;
        }

        public Builder inspectorId(Long val) {
            inspectorId = val;
            return this;
        }

        public ReportDetailsDto build() {
            return new ReportDetailsDto(this);
        }
    }
}
