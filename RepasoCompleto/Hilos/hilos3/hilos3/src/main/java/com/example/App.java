package com.example;


public class App 
{
    public static void main( String[] args )
    {
        Progreso p1 = new Progreso("Archivo1");
        Progreso p2 = new Progreso("Archivo2");
        Progreso p3 = new Progreso("Archivo3");

        p1.start();
        p2.start();
        p3.start();

        // opcional: esperar a que terminen
        try {
            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Todas las tareas han finalizado.");
    }
}
