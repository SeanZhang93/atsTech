//package com.antra.training.repository;
//
//import com.antra.training.model.Department;
//import com.antra.training.model.Employee;
//import com.antra.training.model.User;
//import com.antra.training.util.HibernateUtil;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Repository
//public class UserDAOImpl implements UserDAO {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Override
//    public List<User> findAllUsers(){
//        String hql = "FROM User";
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session s = sessionFactory.openSession();
//             List<User> result = new ArrayList<>();
//        try{
//            Query query = s.createQuery(hql);
//            result = query.list();
//            s.close();
//        }catch (HibernateException e){
//            logger.error("session close exception try again..");
//        }
//        return result;
//    }
//
//    //
////    @Override
////    public User save(User user){
////        Transaction transaction = null;
////        Session session = HibernateUtil.getSessionFactory().openSession();
////        try {
////            transaction = session.beginTransaction();
////            session.save(user);
////            session.close();
////            return user;
////        }catch (Exception e){
////            if (transaction != null) transaction.rollback();
////            logger.error("fail to insert a record");
////            session.close();
////            return null;
////        }
//
////    @Override
////    public User findById(Long Id){
////        String hql = "FROM User as u where u.id = :Id";
////        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
////        Session s = sessionFactory.openSession();
////        try{
////            Query query = s.createQuery(hql);
////            result = query.list();
////            s.close();
////        }catch (HibernateException e){
////            logger.error("session close exception try again..");
////        }
////        return result;
////    }
//    /*
//
//
//    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session s = sessionFactory.openSession();
//        List<Department> result = new ArrayList<>();
//        try{
//            Query query = s.createQuery(hql);
//            result = query.list();
//            s.close();
//        }catch (HibernateException e){
//            logger.error("session close exception try again..");
//        }
//        return result;
//     */
//
//
//}
