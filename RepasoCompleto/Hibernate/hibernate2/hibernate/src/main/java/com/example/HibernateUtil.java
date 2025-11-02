package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private final static SessionFactory SESSION_FACTORY = builderSessionFactory();

    private static SessionFactory builderSessionFactory(){
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(ProductoPOJO.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            throw new RuntimeException("There was an error building the factory session: " + e.getMessage());
        }
        
    }

    private static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    private static void close(){
        getSessionFactory().close();
    }
}
