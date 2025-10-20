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
        String archivo = System.getProperty("user.home") + "/Desktop/ficheros2/datos.txt";

        //mostrar completo
        mostrarArchivo(archivo);

        //añadir al final una linea
        añadirAlFinal(archivo);

        // añadir al principio una linea
        añadirAlPrincipio(archivo);

        
    }

    public static void mostrarArchivo(String archivo) {
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea !=  null) {
                String[] datos = linea.split(",\t");

                for (String dato : datos) {
                    System.out.println(dato);
                }
                linea = br.readLine();
            }
        } catch (java.io.FileNotFoundException e1) {
            System.out.println("Fichero no encontrado:" +e1.getStackTrace());
        } catch (Exception e) {
            System.out.println("Error en la entrada o salida de archivo:" +e.getStackTrace());
        } finally{
            try {
                if (br != null) br .close();
                if (fr != null) fr .close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void añadirAlFinal(String archivo){
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            String nuevaLinea = "Amador, Rivas, Vargas, 17/11/2002, 623315445, amador.rivas@gmail.com";
            bw.write(nuevaLinea);
            bw.newLine();
        } catch (FileNotFoundException e1) {
            System.out.println("Fichero no encontrado:" +e1.getStackTrace());
        } catch (IOException e){
            System.out.println("Error en la entrada/salida");
        } finally{
            try {
                if (bw != null) bw .close();
                if (fw != null) fw .close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void añadirAlPrincipio(String archivo) {
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    BufferedWriter bw = null;

    try {
        // Leer contenido existente
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        StringBuilder contenidoExistente = new StringBuilder();
        String linea;
        while ((linea = br.readLine()) != null) {
            contenidoExistente.append(linea).append(System.lineSeparator());
        }

        // Escribir nueva línea al principio + contenido antiguo
        fw = new FileWriter(archivo);
        bw = new BufferedWriter(fw);
        String nuevaLinea = "Nuevo, Inicio, Linea, 01/01/2024, 600000000,";
        bw.write(nuevaLinea);
        bw.newLine();
        bw.write(contenidoExistente.toString());

    } catch (FileNotFoundException e) {
        System.out.println("Fichero no encontrado: " + e.getMessage());
    } catch (IOException e) {
        System.out.println("Error en entrada/salida: " + e.getMessage());
    } finally {
        try {
            if (br != null) br.close();
            if (fr != null) fr.close();
            if (bw != null) bw.close();
            if (fw != null) fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
