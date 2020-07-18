package com.antra.training.repository;

import com.antra.training.model.User;

import java.util.List;

public interface UserDAO {
    User save(User user);
//    User findById(Long Id);
//    User getUserByEmail(String email);
//    User getUserByCredentials(String email, String password);
    void delete(User u);
    List<User> findAllUsers();
}
