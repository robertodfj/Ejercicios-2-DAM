package acceso_a_datos.ficheros.ejercicio_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo {
    public static void main(String[] args) {
        //añadirAlFinal();
        //mostrar();
        añadirAlPrincipio();
    }


    public static void mostrar(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_1/datos.txt";

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) !=null) {
                String[] datos = linea.split("[,\t]");

                for(String dato : datos){
                    System.out.println(dato + " ");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e1) {
           System.out.println("Archivo no encontrado");
        } catch( IOException e){
            System.out.println("Error en entrada o salida");
        }

        try {
            if(br != null) br.close();
            if(fr != null) fr.close();
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }

    }

    public static void añadirAlFinal(){
        // añadir retorno de carro (un intro en el archivo)
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_1/datos.txt";

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(archivo, true); // añadimos eltrue para escribir al final
            bw = new BufferedWriter(fw);

            String linea = "Laura, Pérez, Rodriguez, 17/11/1982, 914567890 laura.perez.rodriguez@dominio.com";
            bw.write(linea);
            bw.newLine();

        } catch (FileNotFoundException e1) {
           System.out.println("Archivo no encontrado");
        } catch( IOException e){
            System.out.println("Error en entrada o salida");
        }

        try {
            if(bw != null) bw.close();
            if(fw != null) fw.close();
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }

    }

    public static void añadirAlPrincipio(){
        // añadir retorno de carro (un intro en el archivo)
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_1/datos.txt";

        FileWriter fw = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        BufferedReader br = null;
        

        try {
            // Primero leemos 
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            StringBuilder contenidoExistente = new StringBuilder();

            String linea;
            while ((linea = br.readLine())!= null) {
                contenidoExistente.append(linea).append(System.lineSeparator());
            }

            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);

            String lineaNueva = "Laura, Pérez, Rodriguez, 17/11/1982, 914567890 laura.perez.rodriguez@dominio.com";
            bw.write(lineaNueva);
            bw.newLine();

            bw.write(contenidoExistente.toString());

        } catch (FileNotFoundException e1) {
           System.out.println("Archivo no encontrado");
        } catch( IOException e){
            System.out.println("Error en entrada o salida");
        }

        try {
            if(bw != null) bw.close();
            if(fw != null) fw.close();
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }

    }



}