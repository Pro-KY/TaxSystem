package ua.training.persistence.entities;
import java.io.Serializable;
import java.util.Objects;

public class UserType implements Serializable {
    private Long id;
    private String type;

    public UserType(long id) {
        this.id = id;
    }

    public UserType(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserType userType1 = (UserType) o;
        return id == userType1.id &&
                Objects.equals(type, userType1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
