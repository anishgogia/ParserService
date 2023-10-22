package com.pie.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pie.dao.RoleRepository;
import com.pie.dao.UserRepository;
import com.pie.model.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    
    BCryptPasswordEncoder bc =  new BCryptPasswordEncoder();
    

    @Override
    public void save(User user) {
        user.setPassword(bc.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }
}