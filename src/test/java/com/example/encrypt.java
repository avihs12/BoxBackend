package com.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encrypt {


    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "sagar";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }
}
