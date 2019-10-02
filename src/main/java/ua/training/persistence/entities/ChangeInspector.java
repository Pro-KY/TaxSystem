package ua.training.persistence.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class ChangeInspector implements Serializable {
    private long id;
    private Timestamp date;
    private ReportApproval reportApproval;
    private User previousInspector;

    public ChangeInspector(long id, Timestamp date, ReportApproval reportApproval, User previousInspector) {
      this.id = id;
      this.date = date;
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

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }


    public Timestamp getDate() {
      return date;
    }

    public void setDate(Timestamp date) {
      this.date = date;
    }



}
