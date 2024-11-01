package com.example.salesbackend.Service;
import com.example.salesbackend.Constants.HttpStatusCode;
import com.example.salesbackend.DTO.*;
import com.example.salesbackend.Model.User;
import com.example.salesbackend.Repository.UserRepositoryInterface;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepositoryInterface userRepositoryInterface;

    @Autowired
    private UserSessionService userSessionService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private boolean isUserValid(User user) {
        return user.getuserName() != null && !user.getuserName().isEmpty() &&
                user.getuserPass() != null && !user.getuserPass().isEmpty() &&
                user.getuserFullName() != null && !user.getuserFullName().isEmpty() &&
                user.getuserAddress() != null && !user.getuserAddress().isEmpty() &&
                user.getuserEmail() != null && !user.getuserEmail().isEmpty() &&
                user.getuserPhone() != null && !user.getuserPhone().isEmpty() &&
                user.getuserGender() != null && !user.getuserGender().isEmpty();
    }

    public ApiResponse<User> getUserById(long id) {
        Optional<User> userOptional = userRepositoryInterface.getUserById(id);
        if (userOptional.isPresent()) {
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(),HttpStatusCode.SUCCESS.getMessage(), userOptional.get());
        } else {
            return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), "User "+ id +" not found", null);
        }
    }

    public ApiResponse<List<User>> getAllUser(){
        List<User> userList = userRepositoryInterface.getAllUsers();
        if(!userList.isEmpty())
            return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), userList);
        else
            return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<User> addUser(User user) throws MessagingException, UnsupportedEncodingException {
        String token = UUID.randomUUID().toString();
        if(isUserValid(user)) {
            String bcryptPass = user.getuserPass();
            user.setuserPass(bCryptPasswordEncoder.encode(bcryptPass));
            user.setuserStatus("not-active");
            user.setUserActive(token);
            userRepositoryInterface.addUser(user);
            emailService.verifyMail(user.getuserEmail(),user.getUserActive(), user.getuserFullName());
            return new ApiResponse<>(HttpStatusCode.ADD_SUCCESS.getCode(), HttpStatusCode.ADD_SUCCESS.getMessage(), user);
        }
        else
            return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), user);
    }

    public ApiResponse<User> updateUser(long id, User user){
        Optional<User> userOptional = userRepositoryInterface.getUserById(id);
        if(userOptional.isPresent()){
            if(isUserValid(user)) {
                user.setId(id);
                userRepositoryInterface.updateUser(user);
                return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.UPDATE_SUCCESS.getMessage(), user);
            }
            else
                return new ApiResponse<>(HttpStatusCode.DATABASE_PROBLEM.getCode(), HttpStatusCode.DATABASE_PROBLEM.getMessage(), user);
        } else
            return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), null);
    }

    public ApiResponse<User> deleteUser(long id){
        Optional<User> userOptional = userRepositoryInterface.getUserById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            userRepositoryInterface.deleteUser(id);
            return new ApiResponse<>(HttpStatusCode.DELETE_SUCCESS.getCode(), HttpStatusCode.DELETE_SUCCESS.getMessage(), user);
        }
        else return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), null);
    }

    public String checkRole(UserDTO user){
        if(user.getUserRole().equals("admin"))
            return "admin";
        else if(user.getUserRole().equals("employee"))
            return "employee";
        return "customer";
    }

    public void createCookie(HttpServletResponse response, String sessionId){
        Cookie sessionCookie = new Cookie("JSESSIONID", sessionId);
        sessionCookie.setPath("/");
        response.addCookie(sessionCookie);
    }



    public ApiResponse<String> checkLogin(UserDTO user, HttpServletResponse response) {
        UserDTO newUser = userRepositoryInterface.checkUserValid(user);
        if (newUser != null) {
            if (bCryptPasswordEncoder.matches(user.getUserPass(), newUser.getUserPass())) {
                String sessionId = UUID.randomUUID().toString();
                userSessionService.createSession(sessionId, newUser);

                if (newUser.getUserStatus().equals("active")) {
                    createCookie(response,sessionId);
                    return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), sessionId);
                }
                else
                    return new ApiResponse<>(HttpStatusCode.NO_ACTIVE.getCode(), HttpStatusCode.NO_ACTIVE.getMessage(), null);
            } else
                return new ApiResponse<>(HttpStatusCode.WRONG_PASSWORD.getCode(), HttpStatusCode.WRONG_PASSWORD.getMessage(), null);

        } return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), null);
    }

    public ResponseEntity<String> logout(String session, HttpServletResponse response){
        Cookie sessionCookie = new Cookie("JSESSIONID", session);
        sessionCookie.setPath("/");
        sessionCookie.setMaxAge(0);
        response.addCookie(sessionCookie);
        userSessionService.deleteSession(session);
        return ResponseEntity.ok("log-out success");
    }

    public ApiResponse<User> SignUp(User user) throws MessagingException, UnsupportedEncodingException {
        List<User> userList = userRepositoryInterface.getAllUsers();

        Optional<User> existingByUserName = userList.stream().filter(
                u->user.getuserName().equals(u.getuserName())
        ).findFirst();

        if(existingByUserName.isPresent()) return new ApiResponse<>(HttpStatusCode.USER_NAME_EXIT.getCode(), HttpStatusCode.USER_NAME_EXIT.getMessage(), null);

        Optional<User> existingByUserEmail = userList.stream().filter(
                u->user.getuserEmail().equals(u.getuserEmail())
        ).findFirst();

        if(existingByUserEmail.isPresent()) return new ApiResponse<>(HttpStatusCode.USER_EMAIL_EXIT.getCode(), HttpStatusCode.USER_EMAIL_EXIT.getMessage(), null);

        return addUser(user);
    }

    public ApiResponse<String> forgotPassword(ForgotPasswordRequest request) throws MessagingException, UnsupportedEncodingException {
        String token = UUID.randomUUID().toString();
        User user_token = userRepositoryInterface.getUserByEmail(request.getUserEmail());
            if(user_token != null){
                user_token.setUserReset(token);
                userRepositoryInterface.updateUser(user_token);
                emailService.sendMail(user_token.getuserEmail(), token, user_token.getuserFullName());
                return new ApiResponse<>(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), "Mail Sent to "+user_token.getuserEmail());
            }
            else
                return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), null);
    }

    public boolean validToken(String token){
        return userRepositoryInterface.validToken(token);
    }

    public ApiResponse<String> resetPassword(String token, ResetPassword password){
        if (validToken(token)){
            User user = userRepositoryInterface.resetPassword(token);
            String newPass = password.getUserPass();
            user.setuserPass(bCryptPasswordEncoder.encode(newPass));
            userRepositoryInterface.updateUser(user);
            return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), "Password updated");
        }
        return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), "Token is wrong");
    }

    public ApiResponse<String> verifyAccount(String token){
        if (validToken(token)){
            User user = userRepositoryInterface.activeUser(token);
            if(user.getuserStatus().equals("active")) {
                user.setUserActive(null);
                userRepositoryInterface.updateUser(user);
                return new ApiResponse<>(HttpStatusCode.ACTIVED.getCode(), HttpStatusCode.ACTIVED.getMessage(), null);

            }
            user.setuserStatus("active");
            user.setUserActive(null);
            userRepositoryInterface.updateUser(user);
            return new ApiResponse<>(HttpStatusCode.UPDATE_SUCCESS.getCode(), HttpStatusCode.SUCCESS.getMessage(), "Status Updated");
        }
        return new ApiResponse<>(HttpStatusCode.USER_NOT_FOUND.getCode(), HttpStatusCode.USER_NOT_FOUND.getMessage(), null);
    }

}
