package com.example;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtils.buildSessionFactory().openSession();
            session.beginTransaction();

            String sql = "SELECT version();";
		
            String result = (String) session.createNativeQuery(sql).getSingleResult();
            System.out.println(result);
            
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}