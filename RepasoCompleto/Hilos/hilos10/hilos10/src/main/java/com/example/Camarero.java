package com.example;

public class Camarero extends Thread {
    int nombre;
    Cafeteria cafeteria;

    public Camarero(int nombre, Cafeteria cafeteria) {
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
                cafeteria.prepararCafe();
                Thread.sleep(100);
            }
        } catch (Exception e) {
        }
    }

    
    
    
}
