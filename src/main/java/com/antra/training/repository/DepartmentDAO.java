package com.antra.training.repository;

import com.antra.training.model.Department;

import java.util.List;


//why interface? 只要去department table里边，
//方便实现，返回值已经定义好了，不会超出标准
public interface DepartmentDAO {
    Department save(Department department);
    Department update(Department department);
    boolean delete(Department deptName);//TODO, check
    List<Department> getDepartments();
}
