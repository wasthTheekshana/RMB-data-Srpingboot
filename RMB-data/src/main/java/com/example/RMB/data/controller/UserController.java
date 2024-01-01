package com.example.RMB.data.controller;

import com.example.RMB.data.entity.User;
import com.example.RMB.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {


    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<User> findByLicenseNumber(@RequestParam(value ="lNumber") String lNumber){
        return userService.findByLicenseNumber(lNumber);
    }

}
