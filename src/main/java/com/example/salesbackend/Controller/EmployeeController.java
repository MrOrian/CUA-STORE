package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.DTO.ResetPassword;
import com.example.salesbackend.Model.Employee;
import com.example.salesbackend.Model.User;
import com.example.salesbackend.Service.EmployeeService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ApiResponse<User> signUp(@RequestBody Employee employee) throws MessagingException, UnsupportedEncodingException {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<User> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("/reset-password")
    public ApiResponse<String> resetPassword(@RequestParam("token") String token, @RequestBody ResetPassword resetPassword) {
        return employeeService.resetPassword(token, resetPassword);
    }

    @GetMapping("/verify")
    public ApiResponse<String> verify(@RequestParam("token") String token) {
        return employeeService.verifyAccount(token);
    }
}
