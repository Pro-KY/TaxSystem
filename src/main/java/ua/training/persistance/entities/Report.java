package ua.training.persistance.entities;


import java.io.Serializable;

public class Report implements Serializable {
    private Long id;
    private TaxType taxType;
    private double sum;
    private int quarter;

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public Report() {}

    public Report(Long id) {
        this.id = id;
    }

    public Report(TaxType taxType) {
        this.taxType = taxType;
    }

    public Report(Long id, TaxType taxType, double sum, int quarter) {
        this.id = id;
        this.taxType = taxType;
        this.sum = sum;
        this.quarter = quarter;
    }

    public Report(TaxType taxType, double sum, int quarter) {
        this.taxType = taxType;
        this.sum = sum;
        this.quarter = quarter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                ", sum=" + sum +
                ", taxType =" + (taxType != null ?  taxType : "") +
                ", quarter=" + quarter +
                '}';
    }
}
