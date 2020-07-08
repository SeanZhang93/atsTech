package com.antra.training.repository;

import com.antra.training.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getRoleByName(String name);
    List<Role> findAllRoles();
}
