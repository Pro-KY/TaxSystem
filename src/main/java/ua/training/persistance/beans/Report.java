package ua.training.persistance.beans;


import java.io.Serializable;
import java.util.Objects;

public class Report implements Serializable {
    private Long id;
    private TaxType taxType;
    private double sum;
    private int quarter;

    public Report(Long id, TaxType taxType, double sum, int quarter) {
        this.id = id;
        this.taxType = taxType;
        this.sum = sum;
        this.quarter = quarter;
    }

    private Report(Builder builder) {
        id = builder.id;
        setTaxType(builder.taxType);
        setSum(builder.sum);
        setQuarter(builder.quarter);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
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

    public static final class Builder {
        private Long id;
        private TaxType taxType;
        private double sum;
        private int quarter;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder taxType(TaxType val) {
            taxType = val;
            return this;
        }

        public Builder sum(double val) {
            sum = val;
            return this;
        }

        public Builder quarter(int val) {
            quarter = val;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", taxTypeId=" + taxType +
                ", sum=" + sum +
                ", quarter=" + quarter +
                '}';
    }
}
