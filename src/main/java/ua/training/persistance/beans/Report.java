package ua.training.persistance.beans;


import java.io.Serializable;
import java.util.Objects;

public class Report implements Serializable {

  private long id;
  private long taxTypeId;
  private double sum;
  private long quarter;

  public Report(long id, long taxTypeId, double sum, long quarter) {
    this.id = id;
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


  public long getTaxTypeId() {
    return taxTypeId;
  }

  public void setTaxTypeId(long taxTypeId) {
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

  public void setQuarter(long quarter) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Report report = (Report) o;
    return id == report.id &&
            taxTypeId == report.taxTypeId &&
            Double.compare(report.sum, sum) == 0 &&
            quarter == report.quarter;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, taxTypeId, sum, quarter);
  }
}
