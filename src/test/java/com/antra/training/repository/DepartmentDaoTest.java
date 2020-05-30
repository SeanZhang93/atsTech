package com.antra.training.repository;

import com.antra.training.model.Department;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class DepartmentDaoTest {
    @Test
    public void getDepartmentsTest(){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        //System.out.println(departmentDAO.getDepartments());
        List<Department> departmentList = departmentDAO.getDepartments();
        assertEquals(0, departmentList.size());
    }
}
/*
HOMEWOR： FINISH 2 DOMAIN CLASS
        WRITE UNIT TESTS FOR EACH METHOD

 */




