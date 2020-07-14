package com.antra.training.controller;


import com.antra.training.model.Employee;
import com.antra.training.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value= "/saveEmp", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Employee saveUser(@RequestBody Employee employee){
        Employee saveUser  = employeeService.save(employee);
        return saveUser;
    }


    @RequestMapping(value= "/listEmp", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> listEmps() { return employeeService.getEmployees();}


    @RequestMapping(value = "/deleteEmpById/{userId}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Boolean deleteEmp(@RequestBody Employee employee){
        Boolean deleteEmp = employeeService.delete(employee);
        return deleteEmp;
    }




//    public Employee save(Employee employee) {return employeeDAO.save(employee);}
//
//    public List<Employee> getEmployees() { return employeeDAO.getEmployees();}
//
//    public boolean delete(Employee employee) {return employeeDAO.delete(employee);}

}
