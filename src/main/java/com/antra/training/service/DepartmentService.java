//package com.antra.training.service;
//
//import com.antra.training.model.Department;
//import com.antra.training.repository.DepartmentDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DepartmentService {
//    @Autowired
//    private DepartmentDAO departmentDAO;
//
//    public Department save(Department department) {return departmentDAO.save(department)}
//
//
//
//}
package com.antra.training.service;

import com.antra.training.model.Department;
import com.antra.training.repository.DepartmentDAO;
import com.antra.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    private Logger logger = LoggerFactory.getLogger(getClass());
    Transaction transaction = null;



    public Department findById(Long id) {
        String hql = "FROM Department c WHERE c.id=:Id";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = HibernateUtil.getSessionFactory().openSession();
        try{
            Query<Department> query = s.createQuery(hql);
            query.setParameter("Id", id);
            Department result = query.uniqueResult();
            s.close();
            return result;
        }catch(HibernateException e){
            logger.error("Failure to retrieve data record", e);
            s.close();
            return null;
        }
    }

}
