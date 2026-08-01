package com.cpt304.usermgmt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegistrationDto(
    @NotBlank 
    String username,

    @Email 
    @NotBlank 
    String email,

    @Size(min = 8) 
    @NotBlank 
    String password,

    @NotBlank 
    String firstName,

    @NotBlank 
    String lastName
) {}
