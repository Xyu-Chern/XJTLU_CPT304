package com.cpt304.usermgmt.dto;

public record UserDataDto(
    String username,
    String email,
    String firstName,
    String lastName
) {}
