package com.antra.training.repository;

import com.antra.training.model.Role;
import com.antra.training.model.User;
import com.antra.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDAO {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Role> getRoleByName(String name) {
        String hql = "FROM Role";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        List<Role> result = new ArrayList<>();
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
    public List<Role> findAllRoles() {
        return null;
    }
}
