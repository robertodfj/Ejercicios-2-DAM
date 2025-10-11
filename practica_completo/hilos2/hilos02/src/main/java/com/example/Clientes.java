package com.example;

public class Clientes extends Thread {
    Estacion estacion;
    int id;

    public Clientes(Estacion estacion, int i) {
        this.estacion = estacion;
        this.id = i;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public int getNum() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public void run() {
        while (true) { 
          try {
            estacion.limpiarCoche(this);
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
        }
        }

}
