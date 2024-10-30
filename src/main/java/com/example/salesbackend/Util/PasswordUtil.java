package com.example.salesbackend.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    public static String encode(String userPass){
        return bcrypt.encode(userPass);
    }
    public static boolean matches(String rawCode, String encode){
        return bcrypt.matches(rawCode, encode);
    }
}
