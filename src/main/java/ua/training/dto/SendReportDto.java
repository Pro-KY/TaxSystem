package ua.training.dto;


import ua.training.persistance.beans.User;

import java.io.Serializable;

public class SendReportDto implements Serializable {
    private long reportTaxtype;
    private long reportContentType;
    private int reportQuarter;
    private double reportSum;
    private String reportFileContent;
    private User user;

    public long getReportContentTypeId() {
        return reportContentType;
    }

    public void setReportContentTypeId(int reportContentTypeId) {
        this.reportContentType = reportContentTypeId;
    }

    public long getReportTaxtypeId() {
        return reportTaxtype;
    }

    public void setReportTaxtypeId(int reportTaxtypeId) {
        this.reportTaxtype = reportTaxtypeId;
    }

    public int getReportQuarter() {
        return reportQuarter;
    }

    public void setReportQuarter(int reportQuarter) {
        this.reportQuarter = reportQuarter;
    }

    public double getReportSum() {
        return reportSum;
    }

    public void setReportSum(double reportSum) {
        this.reportSum = reportSum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReportFileContent() {
        return reportFileContent;
    }

    public void setReportFileContent(String reportFileContent) {
        this.reportFileContent = reportFileContent;
    }

    @Override
    public String toString() {
        return "SendReportDto{" +
                "reportContentTypeId=" + reportTaxtype +
                ", reportTaxtypeId=" + reportContentType +
                ", reportQuarter=" + reportQuarter +
                ", reportSum=" + reportSum +
                '}';
    }
}
