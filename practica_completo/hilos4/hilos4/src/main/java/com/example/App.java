package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Archivos archivo1 = new Archivos("Archivo1.zip");
        Archivos archivo2 = new Archivos("Archivo2.zip");
        Archivos archivo3 = new Archivos("Archivo3.zip");

        archivo1.start();
        archivo2.start();
        archivo3.start();

        try {
            archivo1.join();
            archivo2.join();
            archivo3.join();
            System.out.println("Todos los archivos se han descargado. 🎉");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
