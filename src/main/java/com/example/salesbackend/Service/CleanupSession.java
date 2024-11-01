package com.example.salesbackend.Service;

import com.example.salesbackend.Repository.UserSessionRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CleanupSession {
    @Autowired
    private UserSessionRepositoryInterface userSessionRepositoryInterface;

    @Scheduled(fixedRate = 60000)
    public void cleanupExpiredSession(){
        userSessionRepositoryInterface.deleteExpiredSession();
    }
}
