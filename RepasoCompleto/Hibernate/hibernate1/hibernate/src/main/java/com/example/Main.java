package com.example;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            EmpleadosPOJO empleado1 = new EmpleadosPOJO();
            empleado1.setNombre("Alberto");
            empleado1.setApellido("Jimenez");
            empleado1.setGenero(EmpleadosPOJO.Genero.M);
            empleado1.setFechaNacimiento(new Date(0));
            empleado1.setFechaContratacion(new Date(0));

            session.persist(empleado1);
            tx.commit();

            System.out.println("Empleado añadido correctamente");

        } catch (Exception e) {
            System.out.println("Error al añadir empleado" +e.getMessage());
        }

    }
}