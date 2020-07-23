//package com.antra.training.repository;
//
//import com.antra.training.model.Role;
//import com.antra.training.model.User;
//import com.antra.training.util.HibernateUtil;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RoleDaoImpl implements RoleDAO {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Override
//    public Role getRoleByName(String name) {
//        String hql = "FROM Role as r where lower(r.name) = :name";
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session s = sessionFactory.openSession();
//        try{
//            Query <Role> query = s.createQuery(hql);
//            query.setParameter("name", name);
//            Role result = query.uniqueResult(); //TODO: uniqueResult
//            s.close();
//            return result;
//        }catch (HibernateException e){
//            logger.error("session close exception try again..");
//        }
//        return null;
//    }
//
//    @Override
//    public List<Role> findAllRoles() {
//        String hql = "FROM ROLE";
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session s = sessionFactory.openSession();
//        List<Role> result = new ArrayList<>();
//
//        try {
//            Query <Role> query = s.createQuery(hql);
//            result = query.list();
//            s.close();
//
//        }catch (Exception e){
//            logger.error("session close exception try again....", e);
//            s.close();
//        }
//        return null;
//    }
//
//    @Override
//    public Role findById(Long id) {
//        String hql = "FROM Role r where r.id = :Id";
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session s = sessionFactory.openSession();
//
//        return null;
//    }
//
//    @Override
//    public Role save(Role role) {
//        return null;
//    }
//
//    @Override
//    public void delete(Role role) {
//
//    }
//
//    @Override
//    public Role update(Role role) {
//        return null;
//    }
//}
