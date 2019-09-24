package ua.training.persistance.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class ChangeInspectorEvent implements Serializable {
    private long id;
    private java.sql.Timestamp date;
    private long approved;
    private long sendReportEventId;

    public ChangeInspectorEvent(long id, Timestamp date, long approved, long sendReportEventId) {
      this.id = id;
      this.date = date;
      this.approved = approved;
      this.sendReportEventId = sendReportEventId;
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


    public long getApproved() {
      return approved;
    }

    public void setApproved(long approved) {
      this.approved = approved;
    }


    public long getSendReportEventId() {
      return sendReportEventId;
    }

    public void setSendReportEventId(long sendReportEventId) {
      this.sendReportEventId = sendReportEventId;
    }

  @Override
  public String toString() {
    return "ChangeInspectorEvent{" +
            "id=" + id +
            ", date=" + date +
            ", approved=" + approved +
            ", sendReportEventId=" + sendReportEventId +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChangeInspectorEvent that = (ChangeInspectorEvent) o;
    return id == that.id &&
            approved == that.approved &&
            sendReportEventId == that.sendReportEventId &&
            Objects.equals(date, that.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, approved, sendReportEventId);
  }
}
