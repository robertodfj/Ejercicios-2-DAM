package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        String archivo = System.getProperty("user.home") + "/Desktop/ficheros3/datos.txt";

        // Mostrar contenido del archivo
        mostrarConetenico(archivo);

        // Añadir una línea al archivo (final)
        añadirLinea(archivo);

        // Añadir linea (principio)
        añadirPrincipio(archivo);
    }

    public static void mostrarConetenico(String archivo){
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split(",\t");
                for (String dato : datos) {
                    System.out.println(dato);
                }
                linea = br.readLine();
            }

        } catch (FileNotFoundException e1) {
            System.out.println("Error al abrir arvhivo" + e1.getMessage());
        } catch (IOException e){
            System.out.println("Error de E/S: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }

    public static void añadirLinea(String archivo){
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            bw.write("Nueva línea añadida al archivo");
            bw.newLine();

            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void añadirPrincipio(String archivo){
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder contenidoExistente = new StringBuilder();
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea != null) {
                contenidoExistente.append(linea).append(System.lineSeparator());
                linea = br.readLine();
            }
            br.close();
            fr.close();

            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Línea añadida al principio");
            bw.newLine();
            bw.write(contenidoExistente.toString());

            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarLinea(String archivo) {
    FileReader fr = null;
    BufferedReader br = null;
    StringBuilder contenidoFinal = new StringBuilder();

    try {
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            // Si la línea NO contiene "Amador", la mantenemos
            if (!linea.contains("Amador")) {
                contenidoFinal.append(linea).append(System.lineSeparator());
            }
        }

        br.close();
        fr.close();

        // Sobrescribir el archivo con las líneas que queremos conservar
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenidoFinal.toString());
        bw.close();
        fw.close();

        System.out.println("✅ Línea que contenía 'Amador' eliminada correctamente.");

    } catch (FileNotFoundException e1) {
        System.out.println("Error al abrir archivo: " + e1.getMessage());
    } catch (IOException e) {
        System.out.println("Error de E/S: " + e.getMessage());
    } finally {
        try {
            if (br != null) br.close();
            if (fr != null) fr.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo: " + e.getMessage());
        }
    }
}
}
