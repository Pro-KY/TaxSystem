package ua.training.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class SentReportsDto implements Serializable {
    private Long reportApprovalId;
    private Long reportId;
    private String state;
    private String inspectorName;
    private String userName;
    private Timestamp timestamp;

    public SentReportsDto(Long reportId, String state, String inspectorName, String userName, Timestamp timestamp, Long reportApprovalId) {
        this.reportId = reportId;
        this.state = state;
        this.inspectorName = inspectorName;
        this.userName = userName;
        this.timestamp = timestamp;
        this.reportApprovalId = reportApprovalId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getReportApprovalId() {
        return reportApprovalId;
    }

    public void setReportApprovalId(Long reportApprovalId) {
        this.reportApprovalId = reportApprovalId;
    }

    @Override
    public String toString() {
        return "SentReportsDto{" +
                "reportApprovalId=" + reportApprovalId +
                ", reportId=" + reportId +
                ", state='" + state + '\'' +
                ", inspectorName='" + inspectorName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
