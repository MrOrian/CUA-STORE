package com.example.salesbackend.DTO;

public class UserDTO {
    private long id;
    private String userName;
    private String userPass;
    private String userEmail;
    private String userRole;
    private String userStatus;
    private String userReset;

    public UserDTO() {
    }

    public UserDTO(String userName, String userPass, String userRole, String userEmail, String userStatus, String userReset ) {
        this.userName = userName;
        this.userPass = userPass;
        this.userRole = userRole;
        this.userEmail = userEmail;
        this.userStatus = userStatus;
        this.userReset = userReset;
    }

    public UserDTO(long id, String userName, String userPass, String userEmail, String userRole, String userReset) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.userReset = userReset;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserReset() {
        return userReset;
    }

    public void setUserReset(String userReset) {
        this.userReset = userReset;
    }
}
