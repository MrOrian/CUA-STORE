package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.DTO.UserSession;
import com.example.salesbackend.Service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class UserSessionController {
    @Autowired
    private UserSessionService userSessionService;

    @GetMapping("/{session}")
    public ApiResponse<UserSession> getUser (@PathVariable String session){
        return userSessionService.getUser(session);
    }
}
