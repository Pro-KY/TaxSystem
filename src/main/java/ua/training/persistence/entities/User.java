package ua.training.persistence.entities;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String organization;
    private String email;
    private String password;
    private String address;
    private UserType userType;

    public User() {}

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String firstName, String lastName, String organization, String email, String password, String address, UserType userType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userType = userType;
    }

    //    public User(Long id, String firstName, String lastName, String organization, String email, String password, String address, Long userType) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.organization = organization;
//        this.email = email;
//        this.password = password;
//        this.address = address;
//        this.userType = userType;
//    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", organization='" + organization + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", userType=" + userType +
                '}';
    }
}
