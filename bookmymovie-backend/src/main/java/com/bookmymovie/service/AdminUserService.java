package com.bookmymovie.service;

import org.springframework.stereotype.Service;

@Service
public class AdminUserService {
    public boolean authenticate(String username, String password) {
        // simple hardcoded user (later replace with DB)
        return "admin".equals(username) && "password123".equals(password);
    }
}