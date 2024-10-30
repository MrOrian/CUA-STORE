package com.example.salesbackend.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee extends User{

    public Employee(String userName, String userPass, String userFullName, String userRole, LocalDate userDate, String userAddress, String userEmail, String userPhone, String userGender, String userStatus) {
        super(userName, userPass, userFullName, "Employee", userDate, userAddress, userEmail, userPhone, userGender, userStatus);
    }

}
