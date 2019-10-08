package ua.training.dto;

import ua.training.persistence.entities.Report;

public class ReportDetailsDto {
    private Long reportApprovalId;
    private Report report;
    private String refusalCause;
    private Long approvalStateId;
    private String inspectorName;
    private String userName;
    private Long inspectorId;
    private Long userTypeId;

    private ReportDetailsDto(Builder builder) {
        reportApprovalId = builder.reportApprovalId;
        report = builder.report;
        refusalCause = builder.refusalCause;
        approvalStateId = builder.approvalStateId;
        inspectorName = builder.inspectorName;
        userName = builder.userName;
        inspectorId = builder.inspectorId;
        userTypeId = builder.userTypeId;
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

    public Long getUserTypeId() {
        return userTypeId;
    }

    public String getUserName() {
        return userName;
    }


    public static final class Builder {
        private Long reportApprovalId;
        private Report report;
        private String refusalCause;
        private Long approvalStateId;
        private String inspectorName;
        private String userName;
        private Long inspectorId;
        private Long userTypeId;

        public Builder() {
        }

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

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder inspectorId(Long val) {
            inspectorId = val;
            return this;
        }

        public Builder userTypeId(Long val) {
            userTypeId = val;
            return this;
        }

        public ReportDetailsDto build() {
            return new ReportDetailsDto(this);
        }
    }

    @Override
    public String toString() {
        return "ReportDetailsDto{" +
                "reportApprovalId=" + reportApprovalId +
                ", report=" + report +
                ", refusalCause='" + refusalCause + '\'' +
                ", approvalStateId=" + approvalStateId +
                ", inspectorName='" + inspectorName + '\'' +
                ", userName='" + userName + '\'' +
                ", inspectorId=" + inspectorId +
                ", userTypeId=" + userTypeId +
                '}';
    }
}
