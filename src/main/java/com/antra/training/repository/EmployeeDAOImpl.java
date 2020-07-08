package com.antra.training.repository;

import com.antra.training.model.Department;
import com.antra.training.model.Employee;
//import com.antra.training.model.Role;
import com.antra.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        String hql = "SELECT e FROM Empoyee e";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        List<Employee> result = new ArrayList<>();
        try{
            Query query = s.createQuery(hql);
            result = query.list();
            s.close();
        }catch (HibernateException e){
            logger.error("session close exception try again..");
        }
        return result;
    }

    @Override
    public boolean delete(Employee employee) {
        String hql = "DELETE Employee as emp where emp.id = :Id";
        int deltedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Department> query = session.createQuery(hql);
            query.setParameter("Id", employee.getId());
            deltedCount = query.executeUpdate();
            transaction.commit();
            session.close();
            return deltedCount >= 1? true : false;


        }catch (HibernateException e ){
            if (transaction != null) transaction.rollback();
            session.close();
            logger.error("unable to delete");
        }
        return false;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }


//    @Override
//    public Employee save(Employee employee) {
//        return null;
//    }
//
//    @Override
//    public List<Employee> getEmployees() {
//        return null;
//    }

//    @Override
//    public List<Employee> getEmployee() {
//        return null;
//    }

//
//    @Override
//    public Employee update(Employee employee) {
//        return null;
//    }
//
//    @Override
//    public Employee getEmployeeByName(String name) {
//        return null;
//    }


}
