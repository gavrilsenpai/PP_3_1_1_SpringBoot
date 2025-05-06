package com.example.pp_3_1_1_springboot.dao;

import com.example.pp_3_1_1_springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        User user1 = entityManager.find(User.class, user.getId());
        if (user1 == null) {
            throw new EntityNotFoundException("Пользователь для обновления не найден: id = " + user.getId());
        }
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь для удаления не найден: id = " + id);
        }
        entityManager.remove(user);
    }

    @Override
    public User getById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь с id = " + id + " не найден");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}