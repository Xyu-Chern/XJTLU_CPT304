package com.cpt304.usermgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt304.usermgmt.dto.UserDataDto;
import com.cpt304.usermgmt.dto.UserRegistrationDto;
import com.cpt304.usermgmt.exception.UserAlreadyExistsException;
import com.cpt304.usermgmt.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<?> userRegistration(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        try{
            UserDataDto userDataDto = authService.userRegistration(userRegistrationDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(userDataDto);
        } catch (UserAlreadyExistsException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
