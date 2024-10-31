package com.example.salesbackend.Service;

import com.example.salesbackend.DTO.ApiResponse;
import com.example.salesbackend.DTO.ResetPassword;
import com.example.salesbackend.Model.Customer;

import com.example.salesbackend.Model.User;
import com.example.salesbackend.Repository.UserRepositoryInterface;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class CustomerService {
    @Autowired
    private UserService userService;

    public ApiResponse<User> addCustomer(Customer customer) throws MessagingException, UnsupportedEncodingException {
        customer.setuserRole("customer");
        return userService.SignUp(customer);
    }

    public ApiResponse<User> updateCustomer(Long id, Customer customer){
        return userService.updateUser(id, customer);
    }

    public ApiResponse<User> deleteCustomer(Long id){
        return userService.deleteUser(id);
    }

    public ApiResponse<String> resetPassword(String token, ResetPassword resetPassword){
        return userService.resetPassword(token, resetPassword);
    }

    public ApiResponse<String> verifyAccount(String token){
        return userService.verifyAccount(token);
    }
}
