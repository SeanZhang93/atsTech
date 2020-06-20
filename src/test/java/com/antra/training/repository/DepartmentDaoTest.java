package com.antra.training.repository;

import com.antra.training.ApplicationBootstrap;
import com.antra.training.model.Department;
import com.antra.training.util.HibernateUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= ApplicationBootstrap.class)
public class DepartmentDaoTest {

//    @Test
//    public void getDepartmentsTest(){
//        DepartmentDAO departmentDAO = new DepartmentDAO();
//        //System.out.println(departmentDAO.getDepartments());
//        List<Department> departmentList = departmentDAO.getDepartments();
//        assertEquals(0, departmentList.size());
//    }


    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    @Autowired
    private DepartmentDAO departmentDao;
    @Autowired
    private Department d1;


    @Before
    public void setup(){
         departmentDao = new DepartmentDaoImpl();
         d1 = new Department();
         d1.setName("hr");
         d1=departmentDao.save(d1);
    }

    @After
    public void tearDown() {
        departmentDao.delete(d1);
    }

    @Test
    public void getDepartmentsTest(){
        List<Department> departments = departmentDao.getDepartments();
        int expect = 1;
        Assert.assertEquals(1, departments.size());
        logger.error("all clear");
  }

//    @Test
//    @Transactional
//    public void departmentSaveTest(){
//
//    }



}
/*
HOMEWOR： FINISH 2 DOMAIN CLASS
        WRITE UNIT TESTS FOR EACH METHOD

 */




