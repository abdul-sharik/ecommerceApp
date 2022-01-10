package com.example.user.service;


import com.example.user.dao.UserDAO;
import com.example.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public Optional<User> findById(int userId) {
        return userDAO.findById(userId);
    }

    public boolean createUser(User user) {
        User result = userDAO.saveAndFlush(user);
        return result != null;
    }

    public List<User> findAllUser(){
       return userDAO.findAll();
    }

    public boolean updateUser(User user) {
        User result = userDAO.save(user);
        return result != null;
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }
}