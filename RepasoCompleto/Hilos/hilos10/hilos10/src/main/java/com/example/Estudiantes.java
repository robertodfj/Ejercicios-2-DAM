package com.example;

public class Estudiantes extends Thread {
    int nombre;
    Cafeteria cafeteria;

    public Estudiantes(int nombre, Cafeteria cafeteria) {
        this.nombre = nombre;
        this.cafeteria = cafeteria;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (true) { 
                cafeteria.usarTaza();
                Thread.sleep(100);
                cafeteria.terminarTaza();
            }
        } catch (Exception e) {
        }
    }
}
