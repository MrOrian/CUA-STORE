package com.example.salesbackend.Model;


import java.sql.Date;
import java.time.LocalDate;

public class User {
    private long id;
    private String userName;
    private String userPass;
    private String userFullName;
    protected String userRole;
    private LocalDate userDate;
    private String userAddress;
    private String userEmail;
    private String userPhone;
    private String userGender;
    private String userStatus;
    private String userReset;
    private String userActive;

    public User() {
    }

    public User(String userName, String userPass, String userFullName, String userRole, LocalDate userDate, String userAddress, String userEmail, String userPhone, String userGender, String userStatus) {
        this.userName = userName;
        this.userPass = userPass;
        this.userFullName = userFullName;
        this.userRole = userRole;
        this.userDate = userDate;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userGender = userGender;
        this.userStatus = userStatus;
    }

    public User(long id,String userName, String userPass, String userFullName, String userRole, LocalDate userDate, String userAddress, String userEmail, String userPhone, String userGender, String userStatus, String userReset, String userActive) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
        this.userFullName = userFullName;
        this.userRole = userRole;
        this.userDate = userDate;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userGender = userGender;
        this.userStatus = userStatus;
        this.userReset = userReset;
        this.userActive = userActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getuserPass() {
        return userPass;
    }

    public void setuserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getuserFullName() {
        return userFullName;
    }

    public void setuserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getuserRole() {
        return userRole;
    }

    public void setuserRole(String userRole) {
        this.userRole = userRole;
    }

    public LocalDate getuserDate() {
        return userDate;
    }

    public void setuserDate(LocalDate userDate) {
        this.userDate = userDate;
    }

    public String getuserAddress() {
        return userAddress;
    }

    public void setuserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getuserEmail() {
        return userEmail;
    }

    public void setuserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getuserPhone() {
        return userPhone;
    }

    public void setuserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getuserGender() {
        return userGender;
    }

    public void setuserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getuserStatus() {
        return userStatus;
    }

    public void setuserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserReset() {
        return userReset;
    }

    public void setUserReset(String userReset) {
        this.userReset = userReset;
    }

    public String getUserActive() {
        return userActive;
    }

    public void setUserActive(String userActive) {
        this.userActive = userActive;
    }
}
