package com.antra.training.repository;

import com.antra.training.model.Department;
import com.antra.training.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee employee);
    List<Employee> getEmployees();
    boolean delete(Employee employee);//TODO, check
    Employee update(Employee employee);
    Employee getEmployeeByName(String name);
    Department getEmployeeByCredentials(String email, String password)；

    }
