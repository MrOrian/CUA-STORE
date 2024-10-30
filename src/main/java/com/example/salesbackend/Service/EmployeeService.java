package com.example.salesbackend.Service;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.DTO.ResetPassword;
import com.example.salesbackend.Model.Employee;
import com.example.salesbackend.Model.User;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmployeeService {
    @Autowired
    private UserService userService;

    public ApiResponse<User> addEmployee(Employee employee) throws MessagingException, UnsupportedEncodingException {
        return userService.addUser(employee);
    }

    public ApiResponse<User> updateEmployee(Long id, Employee employee){
        return userService.updateUser(id, employee);
    }

    public ApiResponse<User> deleteEmployee(Long id){
        return userService.deleteUser(id);
    }

    public ApiResponse<String> resetPassword(String token, ResetPassword resetPassword){
        return userService.resetPassword(token, resetPassword);
    }

    public ApiResponse<String> verifyAccount(String token){
        return userService.verifyAccount(token);
    }
}

