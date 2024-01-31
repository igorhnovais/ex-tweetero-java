package com.tweetero.api.services;

import org.springframework.stereotype.Service;

import com.tweetero.api.dtos.UserDTO;
import com.tweetero.api.models.UserModel;
import com.tweetero.api.repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel saveUser(UserDTO dto) {
        UserModel user = new UserModel(dto);
        return userRepository.save(user);
    }

    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    
}
