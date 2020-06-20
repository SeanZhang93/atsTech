package com.antra.training.repository;

import com.antra.training.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getEmployee() {
        return null;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }


}
