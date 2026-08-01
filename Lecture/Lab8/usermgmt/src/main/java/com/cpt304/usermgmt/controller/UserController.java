package com.cpt304.usermgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt304.usermgmt.exception.UserNotFoundException;
import com.cpt304.usermgmt.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
        } catch(UserNotFoundException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        } catch(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    
    
}
