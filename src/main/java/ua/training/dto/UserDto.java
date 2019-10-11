package ua.training.dto;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String organization;
    private String email;
    private String password;
    private String address;
    private Integer userTypeId;

    public UserDto() {}

    public UserDto(Long id) {
        this.id = id;
    }

    public UserDto(Long id, String firstName, String lastName, String organization, String email, String password, String address, Integer userTypeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userTypeId = userTypeId;
    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }
}
