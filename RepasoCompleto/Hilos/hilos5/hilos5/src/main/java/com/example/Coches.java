package com.example;

public class Coches extends Thread {
    String nombre;
    int distancia = 100;

    public Coches(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    @Override
    public void run() {
        try {
            while (distancia > 0) {
               mostrarRecorrido();
                distancia -= (int) (Math.random() * 10 + 1);
                Thread.sleep(200);
            }
            System.out.println(nombre + " ha llegado a la meta");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void mostrarRecorrido(){
        int longitud = 20;
        int recorrido = (int) ((100 - distancia) / 5);
        StringBuilder barra = new StringBuilder("[");

        for (int i = 0; i < longitud; i++) {
            if (i < recorrido) {
                barra.append("=");
            } else if (i == recorrido) {
                barra.append(">");
            } else {
                barra.append(" ");
            }
        }
        barra.append("] ").append(nombre).append(" Distancia restante: ").append(distancia);
        System.out.println(barra.toString());
    } 

}
