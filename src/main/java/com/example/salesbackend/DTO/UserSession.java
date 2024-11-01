package com.example.salesbackend.DTO;

import java.sql.Timestamp;

public class UserSession {
    private String sessionId;
    private String userName;
    private String role;
    private Timestamp createAt;
    private Timestamp expireAt;

    public UserSession() {
        this.createAt = new Timestamp(System.currentTimeMillis());
        this.expireAt = new Timestamp(System.currentTimeMillis()+30*60*1000);
    }

    public UserSession(String sessionId, String userName, String role) {
        this.sessionId = sessionId;
        this.userName = userName;
        this.role = role;
        this.createAt = new Timestamp(System.currentTimeMillis());
        this.expireAt = new Timestamp(System.currentTimeMillis()+30*60*1000);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }
}