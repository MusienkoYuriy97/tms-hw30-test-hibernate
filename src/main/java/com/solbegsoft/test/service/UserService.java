package com.solbegsoft.test.service;

import com.solbegsoft.test.model.User;
import com.solbegsoft.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(String name, String username, String password){
        if (userRepository.contains(username)){
            throw new RuntimeException("Username already exist");
        }else {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(password);
            userRepository.save(user);
        }
    }
}
