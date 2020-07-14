package com.antra.training.repository;

import com.antra.training.ApplicationBootstrap;
import com.antra.training.model.Department;
import com.antra.training.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ApplicationBootstrap.class)
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDAO employeeDAO;
    private Employee testObject;

    @Autowired
    private DepartmentDAO departmentDao;
    private Department d1;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Before
    public void setUp(){
        d1 = new Department();
//        d1.setId((long)1);
        d1.setName("hr1");
        departmentDao.save(d1);
        testObject = new Employee();
        testObject.setEmail("zhang3@gmail.com");
        testObject.setFirstName("Zhang");
        testObject.setLastName("3");
        testObject.setEmployeeName("Zhang San");
        testObject.setDepartment(d1);
        employeeDAO.save(testObject);
    }
    //department 13
// emloy 12 sean 13
    @After
    public void tearDown(){
        employeeDAO.delete(testObject);
        departmentDao.delete(d1);
    }

    @Test
    public void getEmployeeTest(){
        List<Employee> employeeList = employeeDAO.getEmployees();
        assertEquals(1, employeeList.size());
        logger.info("EmployeeDAO TEST all clear");

    }
}
