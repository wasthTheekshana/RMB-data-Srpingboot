package com.example.RMB.data.service;

import com.example.RMB.data.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<User> findByLicenseNumber(String lNumber);
}
