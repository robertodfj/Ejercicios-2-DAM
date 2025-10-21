package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        // Ficheros CSV
        String archivo = System.getProperty("user.home") + "/Desktop/ficheros/data.csv";
        leerCSV(archivo); // ahora ya imprime dentro del método
    }

    public static void leerCSV(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                for (String campo : campos) {
                    System.out.print(campo + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}