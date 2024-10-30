package com.example.salesbackend.Controller;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.DTO.ResetPassword;
import com.example.salesbackend.Model.Customer;
import com.example.salesbackend.Model.User;
import com.example.salesbackend.Service.CustomerService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ApiResponse<User> signUp(@RequestBody Customer customer) throws MessagingException, UnsupportedEncodingException {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateCustomer(@PathVariable Long id, Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<User> deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

    @PostMapping("/reset-password")
    public ApiResponse<String> resetPassword(@RequestParam("token") String token, ResetPassword resetPassword) {
        return customerService.resetPassword(token, resetPassword);
    }

    @GetMapping("/verify")
    public ApiResponse<String> verify(@RequestParam("token") String token) {
        return customerService.verifyAccount(token);
    }
}
