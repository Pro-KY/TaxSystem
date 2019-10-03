package ua.training.dto;

import java.io.Serializable;

public class ReportDto implements Serializable {
    private long reportId;
    private long taxtypeId;
    private long quarterId;
    private double income;

    public ReportDto(long reportId, long reportTaxtypeId, long quarterId, double income) {
        this.reportId = reportId;
        this.taxtypeId = reportTaxtypeId;
        this.quarterId = quarterId;
        this.income = income;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public long getTaxtypeId() {
        return taxtypeId;
    }

    public void setTaxtypeId(long taxtypeId) {
        this.taxtypeId = taxtypeId;
    }

    public long getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(long quarterId) {
        this.quarterId = quarterId;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
