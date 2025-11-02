package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            ProductoPOJO producto1 = new ProductoPOJO();
            producto1.setNombre("Teclado inalambrico");
            producto1.setDescripcion("Apple magic keyboard");
            producto1.setCategoria_id(8);
            producto1.setStock(1);

            session.persist(producto1);
            tx.commit();

            session.close();
            HibernateUtil.getSessionFactory().close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}