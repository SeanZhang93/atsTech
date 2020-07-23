package com.antra.training.service;


import com.antra.training.model.Department;
import com.antra.training.model.Employee;
import com.antra.training.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee save(Employee employee) {return employeeDAO.save(employee);}

    public List<Employee> getEmployees() { return employeeDAO.getEmployees();}

    public boolean delete(Employee employee) {return employeeDAO.delete(employee);}

//    public Department getEmployeeByCredentials(String email, String password){return employeeDAO.getEmployeeByCredentials(email,password);};




}
