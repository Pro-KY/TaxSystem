package ua.training.persistance.beans;


import java.io.Serializable;
import java.sql.Timestamp;

public class SendReportEvent implements Serializable {
    private Long id;
    private Timestamp timestamp;
    private String refusalCause;
    private Long reportStateId;
    private Long reportId;

    public SendReportEvent(Long id, Timestamp timestamp, String refusalCause, Long reportStateId, Long reportId) {
        this.id = id;
        this.timestamp = timestamp;
        this.refusalCause = refusalCause;
        this.reportStateId = reportStateId;
        this.reportId = reportId;
    }

    public SendReportEvent() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getRefusalCause() {
        return refusalCause;
    }

    public void setRefusalCause(String refusalCause) {
        this.refusalCause = refusalCause;
    }

    public Long getReportStateId() {
        return reportStateId;
    }

    public void setReportStateId(Long reportStateId) {
        this.reportStateId = reportStateId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return "SendReportEvent{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", refusalCause='" + refusalCause + '\'' +
                ", reportStateId=" + reportStateId +
                ", reportId=" + reportId +
                '}';
    }
}
