package com.example.pp_3_1_1_springboot.service;

import com.example.pp_3_1_1_springboot.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserService {
    void add(SecurityProperties.User user);
    void update(SecurityProperties.User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAllUsers();
}
