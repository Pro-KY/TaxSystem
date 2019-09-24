package ua.training.persistance.beans;


import java.io.Serializable;

public class Report implements Serializable {
    private Long id;
    private Long taxTypeId;
    private double sum;
    private int quarter;

    public Report() {}

    public Report(Long taxTypeId, double sum, int quarter) {
        this.taxTypeId = taxTypeId;
        this.sum = sum;
        this.quarter = quarter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getTaxTypeId() {
        return taxTypeId;
    }

    public void setTaxTypeId(Long taxTypeId) {
        if(taxTypeId != null && taxTypeId == 0) {
            throw new IllegalArgumentException("wrong taxTypeId value, must be bigger than 0!");
        }

        this.taxTypeId = taxTypeId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public long getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", taxTypeId=" + taxTypeId +
                ", sum=" + sum +
                ", quarter=" + quarter +
                '}';
    }
}
