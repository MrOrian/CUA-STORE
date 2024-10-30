package com.example.salesbackend.DTO;

public class ForgotPasswordRequest {
    private String userEmail;

    public ForgotPasswordRequest() {
    }

    public ForgotPasswordRequest(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
