package com.example.pp_3_1_1_springboot.dao;

import com.example.pp_3_1_1_springboot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAllUsers();
}
