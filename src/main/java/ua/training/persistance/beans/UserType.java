package ua.training.persistance.beans;
import java.io.Serializable;
import java.util.Objects;

public class UserType implements Serializable {

    private long id;
    private String role;

    public UserType(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserType userType1 = (UserType) o;
        return id == userType1.id &&
                Objects.equals(role, userType1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }
}
