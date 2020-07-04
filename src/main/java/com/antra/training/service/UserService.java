package com.antra.training.service;

import com.antra.training.model.User;
import com.antra.training.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;


    public List<User> getAllUsers(){
        List<User> userList= userDAO.findAllUsers();
                return userList;
    }
}
