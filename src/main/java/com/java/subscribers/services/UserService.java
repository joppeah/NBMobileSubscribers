/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.services;

import com.java.subscribers.entities.User;
import com.java.subscribers.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Junior
 */
@Service
public class UserService {
    
    @Autowired
    UserRepository userrepo;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    //method to create users
    public User saveUser(User user)
    {
        user.setUserpassword(passwordEncoder.encode(user.getUserpassword())); 
        return userrepo.save(user); 
    }
    
    //method to list all users
    public List<User> getAllUsers()
    {
        return userrepo.findAll();
    }
    
    public Boolean checkIfUserExists(String username)
    {
        return userrepo.existsByUsername(username);
    }
}
