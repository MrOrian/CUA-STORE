package com.example.salesbackend.Repository;

import com.example.salesbackend.DTO.UserSession;

public interface UserSessionRepositoryInterface {
    UserSession getUserSession(String session);
    void generateSession(UserSession userSession);
    void deleteSession(String session);
    void deleteExpiredSession();
}
