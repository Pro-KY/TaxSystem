package ua.training.persistance.beans;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String organization;
    private String email;
    private String password;
    private String address;
    private Boolean isPhysical;
    private Long userTypeId;

    public User(long id, String firstName, String lastName, String organization, String email, String password, String address, boolean isPhysical, long userTypeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
        this.email = email;
        this.password = password;
        this.address = address;
        this.isPhysical = isPhysical;
        this.userTypeId = userTypeId;
    }

    public User(long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private User(Builder builder) {
        id = builder.id;
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setOrganization(builder.organization);
        setEmail(builder.email);
        setPassword(builder.password);
        setAddress(builder.address);
        isPhysical = builder.isPhysical;
        userTypeId = builder.userTypeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Boolean getPhysical() {
        return isPhysical;
    }

    public void setPhysical(Boolean physical) {
        isPhysical = physical;
    }

    public long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(long userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String organization;
        private String email;
        private String password;
        private String address;
        private Boolean isPhysical;
        private Long userTypeId;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder organization(String val) {
            organization = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder isPhysical(Boolean val) {
            isPhysical = val;
            return this;
        }

        public Builder userTypeId(Long val) {
            userTypeId = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
