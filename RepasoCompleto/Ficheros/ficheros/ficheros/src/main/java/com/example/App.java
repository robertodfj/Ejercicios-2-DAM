package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App 
{

    

    public static void main( String[] args )
    {
        // 1º Ruta del archivo (absoluta)
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/Ejercicios 2ºDAM/RepasoCompleto/Ficheros/datos.txt";
        mostrar(archivo);
    }

    // Leer fichero
    public static void mostrar(String archivo){
        FileReader fr = null;
        BufferedReader br = null;

        System.out.println("Leyendo archivo: " + archivo);

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null){
                String datos[] = linea.split("[,\t]");
                for(String dato : datos){
                    System.out.print(dato + " ");
                }
                System.out.println();
                linea = br.readLine();
            }
        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error en entrada o salida");
        } finally {
            try {
                if(br != null) br.close();
                if(fr != null) fr.close();
            } catch (Exception e) {
                System.out.println("Error en el cierre");
            }
        }
    }
}
