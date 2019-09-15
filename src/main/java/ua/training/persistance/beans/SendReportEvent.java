package ua.training.persistance.beans;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class SendReportEvent implements Serializable {

  private long id;
  private java.sql.Timestamp date;
  private String refusalCause;
  private long reportStateId;
  private long reportId;
  private long userId;
  private long inspectorId;

  public SendReportEvent(long id, Timestamp date, String refusalCause, long reportStateId, long reportId, long userId, long inspectorId) {
    this.id = id;
    this.date = date;
    this.refusalCause = refusalCause;
    this.reportStateId = reportStateId;
    this.reportId = reportId;
    this.userId = userId;
    this.inspectorId = inspectorId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public String getRefusalCause() {
    return refusalCause;
  }

  public void setRefusalCause(String refusalCause) {
    this.refusalCause = refusalCause;
  }


  public long getReportStateId() {
    return reportStateId;
  }

  public void setReportStateId(long reportStateId) {
    this.reportStateId = reportStateId;
  }


  public long getReportId() {
    return reportId;
  }

  public void setReportId(long reportId) {
    this.reportId = reportId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getInspectorId() {
    return inspectorId;
  }

  public void setInspectorId(long inspectorId) {
    this.inspectorId = inspectorId;
  }

  @Override
  public String toString() {
    return "SendReportEvent{" +
            "id=" + id +
            ", date=" + date +
            ", refusalCause='" + refusalCause + '\'' +
            ", reportStateId=" + reportStateId +
            ", reportId=" + reportId +
            ", userId=" + userId +
            ", inspectorId=" + inspectorId +
            '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SendReportEvent that = (SendReportEvent) o;
    return id == that.id &&
            reportStateId == that.reportStateId &&
            reportId == that.reportId &&
            userId == that.userId &&
            inspectorId == that.inspectorId &&
            Objects.equals(date, that.date) &&
            Objects.equals(refusalCause, that.refusalCause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, refusalCause, reportStateId, reportId, userId, inspectorId);
  }
}
