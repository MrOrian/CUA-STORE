package com.example.salesbackend.Repository;

import com.example.salesbackend.DTO.UserDTO;
import com.example.salesbackend.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    Optional<User> getUserById(long id);
    List<User> getAllUsers();
    UserDTO checkUserValid(UserDTO user);
    User getUserByEmail(String email);
    Boolean validToken(String token);
    User resetPassword(String token);
    User activeUser(String token);
}
