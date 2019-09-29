package ua.training.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class SentReportsDto implements Serializable {
    Long reportNumber;
    String state;
    String inspector;
    Timestamp timestamp;

    public SentReportsDto(Long reportNumber, String state, String inspector, Timestamp timestamp) {
        this.reportNumber = reportNumber;
        this.state = state;
        this.inspector = inspector;
        this.timestamp = timestamp;
    }

    public Long getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Long reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
