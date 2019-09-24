package ua.training.persistance.entities;


import java.io.Serializable;
import java.sql.Timestamp;

public class SendReportEvent implements Serializable {
    private Long id;
    private Timestamp date;
    private String refusalCause;
    private ReportState reportState;
    private Report report;
    private User sender;
    private User inspector;

    public SendReportEvent(Long id, Timestamp date, String refusalCause, ReportState reportState, Report report, User sender, User inspector) {
        this.id = id;
        this.date = date;
        this.refusalCause = refusalCause;
        this.reportState = reportState;
        this.report = report;
        this.sender = sender;
        this.inspector = inspector;
    }

    private SendReportEvent(Builder builder) {
        setId(builder.id);
        setDate(builder.date);
        setRefusalCause(builder.refusalCause);
        setReportState(builder.reportState);
        setReport(builder.report);
        setSender(builder.user);
        setInspector(builder.inspector);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getRefusalCause() {
        return refusalCause;
    }

    public void setRefusalCause(String refusalCause) {
        this.refusalCause = refusalCause;
    }

    public ReportState getReportState() {
        return reportState;
    }

    public void setReportState(ReportState reportState) {
        this.reportState = reportState;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getInspector() {
        return inspector;
    }

    public void setInspector(User inspector) {
        this.inspector = inspector;
    }


    public static final class Builder {
        private Long id;
        private Timestamp date;
        private String refusalCause;
        private ReportState reportState;
        private Report report;
        private User user;
        private User inspector;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder date(Timestamp val) {
            date = val;
            return this;
        }

        public Builder refusalCause(String val) {
            refusalCause = val;
            return this;
        }

        public Builder reportState(ReportState val) {
            reportState = val;
            return this;
        }

        public Builder report(Report val) {
            report = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder inspector(User val) {
            inspector = val;
            return this;
        }

        public SendReportEvent build() {
            return new SendReportEvent(this);
        }
    }

    @Override
    public String toString() {
        return "SendReportEvent{" +
                "id=" + id +
                ", date=" + date +
                ", refusalCause='" + refusalCause + '\'' +
                ", reportState=" + reportState +
                ", report=" + report +
                ", sender=" + sender +
                ", inspector=" + inspector +
                '}';
    }
}
