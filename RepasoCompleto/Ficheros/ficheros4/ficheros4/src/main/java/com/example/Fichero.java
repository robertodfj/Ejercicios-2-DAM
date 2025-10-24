package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Fichero extends Thread {
    String ruta = System.getProperty("user.home") + "/Documents/Proyectos/Ejercicios 2ºDAM/RepasoCompleto/Ficheros/ficheros4/data.txt";
    Usuarios usuarios;
    boolean escritor;

    public Fichero(Usuarios usuarios, boolean escritor, String nombre) {
        super(nombre);
        this.usuarios = usuarios;
        this.escritor = escritor;
    }

    @Override
    public void run() {
        try {
            usuarios.empezarUso();
            if (escritor) {
                System.out.println(getName() + " escribiendo en el fichero...");
                escribirFichero(ruta);
            } else {
                System.out.println(getName() + " leyendo el fichero...");
                leerFichero(ruta);
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                usuarios.terminarUso();
                System.out.println(getName() + " ha terminado su uso.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void leerFichero(String ruta) {
        try (FileReader fr = new FileReader(ruta);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void escribirFichero(String ruta) {
        try (FileWriter fw = new FileWriter(ruta, true); 
             BufferedWriter bw = new BufferedWriter(fw)) {
            String nuevaLinea = "Nueva línea escrita por el hilo " + Thread.currentThread().getName();
            bw.write(nuevaLinea);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}