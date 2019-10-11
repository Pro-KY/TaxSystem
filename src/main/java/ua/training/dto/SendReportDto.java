package ua.training.dto;


import ua.training.persistence.entities.User;

import java.io.Serializable;

public class SendReportDto implements Serializable {
    private long taxTypeId;
    private int reportContentTypeId;
    private int quarterId;
    private double sum;
    private String reportFileContent;
    private User user;


    public int getReportContentTypeId() {
        return reportContentTypeId;
    }

    public void setReportContentTypeId(int reportContentTypeId) {
        this.reportContentTypeId = reportContentTypeId;
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
                "taxTypeId=" + taxTypeId +
                ", reportContentTypeId=" + reportContentTypeId +
                ", quarterId=" + quarterId +
                ", reportSum=" + sum +
                ", reportFileContent='" + reportFileContent + '\'' +
                ", user=" + user +
                '}';
    }
}
