package com.cpt304.usermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cpt304.usermgmt.dto.UserDataDto;
import com.cpt304.usermgmt.dto.UserRegistrationDto;
import com.cpt304.usermgmt.exception.UserAlreadyExistsException;
import com.cpt304.usermgmt.model.User;
import com.cpt304.usermgmt.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDataDto userRegistration(UserRegistrationDto userRegistrationDto){
        if(userRepository.existsByUsername(userRegistrationDto.username())){
            throw new UserAlreadyExistsException("Username already exists");
        }

        if(userRepository.existsByEmail(userRegistrationDto.email())){
            throw new UserAlreadyExistsException("Email already exists");
        }

        User user = new User(userRegistrationDto.username(), 
                            userRegistrationDto.email(), 
                            passwordEncoder.encode(userRegistrationDto.password()),
                            userRegistrationDto.firstName(), 
                            userRegistrationDto.lastName(), 
                            true);

        user = userRepository.save(user);

        return new UserDataDto(user.getUsername(), 
        user.getEmail(), user.getFirstName(), user.getLastName());
    }

    // public Authentication authenticate(LoginDto loginDto) {
    //     Authentication authentication = authenticationManager.authenticate(
    //         new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password())
    //     );

    //     SecurityContextHolder.getContext().setAuthentication(authentication);

    //     return authentication;
    // }    
}
