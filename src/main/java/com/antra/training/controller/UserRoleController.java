package com.antra.training.controller;

import com.antra.training.model.Role;
import com.antra.training.model.User;
import com.antra.training.service.RoleService;
import com.antra.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.List;

@Controller
public class UserRoleController {

    @Autowired
    private UserService userService;

    @GetMapping(name = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllUsers(){
        return userService.getAllUsers();

    }


    @Autowired
    private RoleService roleService;

    @GetMapping(name = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> findAllRoles(){
        return userService.getAllUsers();
    }

}
