package com.cpt304.usermgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt304.usermgmt.dto.UserDataDto;
import com.cpt304.usermgmt.exception.UserNotFoundException;
import com.cpt304.usermgmt.model.User;
import com.cpt304.usermgmt.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDataDto getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());

        return new UserDataDto(user.getUsername(), 
                                user.getEmail(), 
                                user.getFirstName(), 
                                user.getLastName());
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
