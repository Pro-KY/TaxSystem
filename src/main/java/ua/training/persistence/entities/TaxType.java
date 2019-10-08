package ua.training.persistence.entities;


import java.io.Serializable;
import java.util.Objects;

public class TaxType implements Serializable {
    private Long id;
    private String type;

    public TaxType(Long id) {
        this.id = id;
    }

    public TaxType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxType taxType = (TaxType) o;
        return Objects.equals(id, taxType.id) &&
                Objects.equals(type, taxType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "TaxType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
