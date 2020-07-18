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

//    @Override
//    public Employee save(Employee employee) {
//
//        Transaction transaction = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.save(employee);
//            transaction.commit();
//            session.close();
//            return employee;
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            logger.error("fail to insert record", e);
//            session.close();
//            return null;
//        }
//    }

    @Override
    public Employee save(Employee employee) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            session.close();
            return employee;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("failure to insert record", e);
            session.close();
            return null;
        }
    }

    @Override
    public List<Employee> getEmployees() {
        String hql = "SELECT e FROM Employee e";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        List<Employee> result = new ArrayList<>();
        try{
            Query query = s.createQuery(hql);
            result = query.list();
        }catch (HibernateException e) {
            logger.error("session close exception try again..",e);
        }finally {
            s.close();
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
            Query<Employee> query = session.createQuery(hql);
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

//    @Override
//    public Employee getEmployeeByCredentials(String email, String password) {
//        String hql = "FROM User as u where lower(u.email) = :email and u.password = :password";
//        Transaction transaction = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        try  {
//            transaction = session.beginTransaction();
//            Query<Employee> query = session.createQuery(hql);
//            query.setParameter("email", email.toLowerCase().trim());
//            query.setParameter("password", password);
//            transaction.commit();
//            session.close();
//            return query.uniqueResult();
//        }catch (Exception e)
//        {
//            logger.error("Can't find user based on given credential info", e.getMessage());
//            return null;
//        }
    //}


    @Override
    public Department getEmployeeByCredentials(String email, String password){
//        select * from departments as dep left join employees as e on a.employee_id=dep.id where dep.id=:Id
        String hql = "FROM Employee as e where lower(e.email) = :email and e.password = :password";
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Department> query = session.createQuery(hql);
            query.setParameter("email",email.toLowerCase().trim());
            query.setParameter("password",password.toLowerCase().trim());
            Department result = query.uniqueResult();
            transaction.commit();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to find credentail",e.getMessage());
            return null;
        }
    }


}
