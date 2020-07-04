package com.antra.training.repository;

import com.antra.training.model.Department;
import com.antra.training.service.DepartmentService;
import com.antra.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentDaoImpl implements DepartmentDAO {
    private Logger logger = LoggerFactory.getLogger(getClass());
    Transaction transaction = null;

    @Override
    public Department save(Department department) {
        try{
            //SessionFactory sf = HibernateUtil
            Session s = HibernateUtil.getSessionFactory().openSession();
            transaction = s.beginTransaction();
            s.save(department);
            transaction.commit();
            s.close();
            }
        catch ( Exception e){
            if (transaction != null) transaction.rollback();
            logger.error("fail to insert record", e);
        }
        return null;
    }


    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public List<Department> getDepartments() {
        String hql = "FROM Department";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        List<Department> result = new ArrayList<>();
        try{
            Query query = s.createQuery(hql);
            result = query.list();
            s.close();
        }catch (HibernateException e){
            logger.error("session close exception try again..");
        }
        return result;
    }


   // FROM Customer c WHERE c.id=:Id

//    @Override
//    public Department getBy(Long id) {
//        String hql = "FROM Customer c WHERE c.id=:Id";
//        SessionFactory session = SessionFactory.openSession();
//        try{
//            Query<Department> query = session.createQuery(hql);
//            query.setParameter("Id", id);
//            Department result = query.uniqueResult();
//            session.close();
//            return result;
//        }catch(HibernateException e){
//            logger.error("Failure to retrieve data record", e);
//            session.close();
//            return null;
//        }
//    }

//    private DepartmentService departmentService;
//
//    public Department updateDepartmentName(Long Id, String name){
//    Department department = departmentService.findById(Id);
//        department.setName(name);
//        department = department.
//    }


    @Override
    public boolean delete(Department dep) {
        String hql = "DELETE Department as dep where dep.id = :Id";
        int deltedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Department> query = session.createQuery(hql);
            query.setParameter("Id", dep.getId());
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


    public Department getDepartmentEagerBy(Long id){
//        select * from departments as dep left join employees as e on a.employee_id=dep.id where dep.id=:Id
        String hql = "FROM Department d LEFT JOIN FETCH d.employees where d.id=:Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Department result = query.uniqueResult();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to retrieve data record",e);
            session.close();
            return null;
        }
    }
}


