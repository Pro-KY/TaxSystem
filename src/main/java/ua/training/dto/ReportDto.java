package ua.training.dto;

import java.io.Serializable;

public class ReportDto implements Serializable {
    private long reportId;
    private long taxTypeId;
    private int quarterId;
    private double income;
    private long reportApprovalId;

    public ReportDto(long reportId, long reportTaxtypeId, int quarterId, double income) {
        this.reportId = reportId;
        this.taxTypeId = reportTaxtypeId;
        this.quarterId = quarterId;
        this.income = income;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public long getTaxTypeId() {
        return taxTypeId;
    }

    public void setTaxTypeId(long taxTypeId) {
        this.taxTypeId = taxTypeId;
    }

    public int getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(int quarterId) {
        this.quarterId = quarterId;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }


    public long getReportApprovalId() {
        return reportApprovalId;
    }

    public void setReportApprovalId(long reportApprovalId) {
        this.reportApprovalId = reportApprovalId;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "reportId=" + reportId +
                ", taxTypeId=" + taxTypeId +
                ", quarterId=" + quarterId +
                ", income=" + income +
                ", reportApprovalId=" + reportApprovalId +
                '}';
    }
}
