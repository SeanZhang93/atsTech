package com.antra.training.util;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.util.Properties;

public class HibernateUtil {
    //定义hibernate,先创建一个空的sessionFactory
    //通过ORM把__转化成__语言


    public static SessionFactory sessionFactory;  //singleton

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                String[] modelPackages = {"com.antra.training"};
                String dbDriver = System.getProperty("database.driver");
                String dbDialect = System.getProperty("database.dialect");
                String dbUrl = System.getProperty("database.url");
                String dbUser = System.getProperty("database.user");
                String dbPassword = System.getProperty("database.password");


                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, dbDriver);
                settings.put(Environment.DIALECT, dbDialect);
                settings.put(Environment.URL, dbUrl);
                settings.put(Environment.USER, dbUser);
                settings.put(Environment.PASS, dbPassword);
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.HBM2DDL_AUTO, "validate");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                EntityScanner.scanPackages(modelPackages).addTo(configuration);
                //StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                ServiceRegistry serviceRegistry = registryBuilder.applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                logger.error("Fail to generate hibernate sessionfactory", e);
            }
        }

        return sessionFactory;
    }

    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);


    public static void main(String[] args){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        logger.info("success geneate sf"+ sf.hashCode());
        sf.close();
    }

    //导入

}
