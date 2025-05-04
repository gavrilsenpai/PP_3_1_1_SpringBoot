package com.example.pp_3_1_1_springboot.service;

import com.example.pp_3_1_1_springboot.dao.UserDao;
import com.example.pp_3_1_1_springboot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(SecurityProperties.User user) {
        userDao.add((User) user);
    }

    @Override
    @Transactional
    public void update(SecurityProperties.User user) {
        userDao.update((User) user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
