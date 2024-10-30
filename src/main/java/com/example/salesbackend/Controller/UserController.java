package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.*;
import com.example.salesbackend.Exception.AppException;
import com.example.salesbackend.Model.User;
import com.example.salesbackend.Service.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable long id) {
        ApiResponse<User> response = userService.getUserById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUser(){
        ApiResponse<List<User>> response = userService.getAllUser();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping
    public ApiResponse<User> addUser(@RequestBody User user) throws MessagingException, UnsupportedEncodingException {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<User> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ApiResponse<UserSession> checkLogin(@RequestBody UserDTO user, HttpSession httpSession){
        return userService.checkLogin(user, httpSession);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> checkLogin(HttpSession httpSession){
        return userService.logout(httpSession);
    }

    @PostMapping("/signup")
    public ApiResponse<User> signUp(@RequestBody User user) throws MessagingException, UnsupportedEncodingException {
        return userService.SignUp(user);
    }

    @PostMapping("/forgot-password")
    public ApiResponse<String> forgotPassword(@RequestBody ForgotPasswordRequest request) throws MessagingException, UnsupportedEncodingException {
        return userService.forgotPassword(request);
    }

    @PostMapping("/reset-password")
    public ApiResponse<String> updatePassword(@RequestParam("token") String token, @RequestBody ResetPassword password){
        return userService.resetPassword(token, password);
    }

    @GetMapping("/verify")
    public ApiResponse<String> verifyAccount(@RequestParam("token") String token){
        return userService.verifyAccount(token);
    }

}
