package com.example;

public class Archivos extends Thread {
    int progreso = 0;
    String nombre;

    public Archivos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (progreso < 100) {
                mostrarProgreso();
                progreso += (int)(Math.random() * 10) + 1;
                Thread.sleep(500);
            }
            System.out.println(nombre + " ha terminado de descargarse. ✅");
        } catch (Exception e) {

        }
    }

    public void mostrarProgreso(){
        int longitud = 20;
        int progresoActual = (progreso * longitud) / 100;
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < longitud; i++) {
            if (i < progresoActual) {
                barra.append("=");
            } else {
                barra.append(" ");
            }
        }
        barra.append("]");
        System.out.println(nombre + ": " + barra + " " + progreso + "%");
    }

    
}
