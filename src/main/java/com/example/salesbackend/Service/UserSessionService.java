package com.example.salesbackend.Service;

import com.example.salesbackend.Constants.HttpStatusCode;
import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.DTO.UserDTO;
import com.example.salesbackend.DTO.UserSession;
import com.example.salesbackend.Repository.UserSessionRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserSessionService {
    @Autowired
    private UserSessionRepositoryInterface userSessionRepositoryInterface;

    public ApiResponse<UserSession> getUser(String session){
        return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), userSessionRepositoryInterface.getUserSession(session));
    }

    public void createSession(String sessionId, UserDTO user){
        UserSession userSession = new UserSession(sessionId, user.getUserName(), user.getUserRole());
        userSessionRepositoryInterface.generateSession(userSession);
    }

    public void deleteSession(String sessionId){
        userSessionRepositoryInterface.deleteSession(sessionId);
    }

}
