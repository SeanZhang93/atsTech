package com.antra.training.repository;

import com.antra.training.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRoleByName(String name);
    List<Role> findAllRoles();
}
