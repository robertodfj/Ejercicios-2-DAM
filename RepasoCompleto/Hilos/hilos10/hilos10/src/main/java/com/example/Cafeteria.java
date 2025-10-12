package com.example;

public class Cafeteria {
    int tazas = 10;
    int tazasVacias = 0;

    public synchronized void prepararCafe() throws InterruptedException{
        while (tazasVacias == 0) { 
            wait();
        }
        tazasVacias--;
        tazas++;
        System.out.println("Café preparado. Tazas restantes: " + tazas);
        notifyAll();
    }

    // estudiante usa taza
    public synchronized void usarTaza() throws InterruptedException{
        while (tazas == 0) { 
            wait();
        }
        tazas--;
        System.out.println("Taza usada y lavada. Tazas disponibles: " + tazas);
        notifyAll();
    }

    public synchronized void terminarTaza() throws InterruptedException{
        tazasVacias++;
        System.out.println("Taza usada y lavada. Tazas disponibles: " + tazas);
        notifyAll();
    }

}
