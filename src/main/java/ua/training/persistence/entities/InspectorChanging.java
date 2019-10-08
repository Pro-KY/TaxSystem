package ua.training.persistence.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class InspectorChanging implements Serializable {
    private Long id;
    private Timestamp timestamp;
    private ReportApproval reportApproval;
    private User previousInspector;

    public InspectorChanging(long id, Timestamp timestamp, ReportApproval reportApproval, User previousInspector) {
      this.id = id;
      this.timestamp = timestamp;
      this.reportApproval = reportApproval;
      this.previousInspector = previousInspector;
    }

    public InspectorChanging(Timestamp timestamp, ReportApproval reportApproval, User previousInspector) {
        this.timestamp = timestamp;
        this.reportApproval = reportApproval;
        this.previousInspector = previousInspector;
    }

    public ReportApproval getReportApproval() {
        return reportApproval;
    }

    public void setReportApproval(ReportApproval reportApproval) {
        this.reportApproval = reportApproval;
    }

    public User getPreviousInspector() {
        return previousInspector;
    }

    public void setPreviousInspector(User previousInspector) {
        this.previousInspector = previousInspector;
    }

    public Long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }


    public Timestamp getTimestamp() {
      return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
      this.timestamp = timestamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InspectorChanging that = (InspectorChanging) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(reportApproval, that.reportApproval) &&
                Objects.equals(previousInspector, that.previousInspector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, reportApproval, previousInspector);
    }
}
