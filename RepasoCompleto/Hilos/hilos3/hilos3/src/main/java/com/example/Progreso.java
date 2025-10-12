package com.example;

public class Progreso extends Thread {
    private int progreso = 0;
    private final String nombre;

    public Progreso(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (progreso < 100) {
                mostrarProgreso(); // imprimimos antes de avanzar (o después, tú eliges)
                progreso += (int) (Math.random() * 10); // 0..9
                if (progreso > 100) progreso = 100; // cap
                Thread.sleep(500);
            }
            mostrarProgreso(); // mostrar 100% final
            System.out.println("✅ Hilo " + nombre + " ha terminado.");
        } catch (InterruptedException e) {
            System.out.println("Hilo " + nombre + " interrumpido.");
            Thread.currentThread().interrupt(); // restaurar estado de interrupción
        }
    }

    public void mostrarProgreso() {
        int longitud = 20; // barras totales
        int progresoActual = (progreso * longitud) / 100; // cuántas barras rellenas

        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < longitud; i++) {
            if (i < progresoActual) barra.append("=");
            else barra.append(" ");
        }
        barra.append("] ").append(progreso).append("%");
        System.out.println(nombre + " " + barra.toString());
    }
}