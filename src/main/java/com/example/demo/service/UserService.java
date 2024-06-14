package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final Map<String, String> users = new HashMap<>();

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        // 初始化一些模拟用户
        users.put("user", passwordEncoder.encode("password"));
    }

    public boolean validateUser(String username, String password) {
        String encodedPassword = users.get(username);
        return encodedPassword != null && passwordEncoder.matches(password, encodedPassword);
    }
}
