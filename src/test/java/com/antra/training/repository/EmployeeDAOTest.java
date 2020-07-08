package com.antra.training.repository;

import com.antra.training.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.List;

public class EmployeeDAOTest {
    private EmployeeDAO employeeDAO;
    private Employee testObject;

    @Before
    public void setUp(){
        employeeDAO = new EmployeeDAOImpl();
        //create new employee
        EmployeeDAOImpl p1 = new EmployeeDAOImpl();

        testObject = new Employee();
        testObject.setEmail("zhang3@gmail.com");
        testObject.setFirstName("Zhang");
        testObject.setLastName("3");
        employeeDAO.save(testObject);
    }

    @After
    public void tearDown(){
    employeeDAO.delete(testObject);
    }

    @Test
    public void getEmployeeTest(){
        List<Employee> employeeList = employeeDAO.getEmployees();
        assertEquals(1, employeeList.size());
    }
}
