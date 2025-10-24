package com.example;

public class Usuarios {
    String ruta = null;;
    boolean enUso = false;
      
    public synchronized void empezarUso() throws InterruptedException {
        while (enUso) {
                wait();
        }
        enUso = true;
    }

    public synchronized void terminarUso() throws InterruptedException {
        enUso = false;
        notifyAll();
    }
}
