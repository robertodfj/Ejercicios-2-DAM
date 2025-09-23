package acceso_a_datos.ficheros.ejercicio_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Ejercicio1 {
    public static void main(String[] args) {
        //mostrarDatos();
        //añadirFinal();
        añadirPrincipio();
    }

    public static void mostrarDatos(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_2/datos.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine();

            while (linea != null) {
                String datos[] = linea.split("[,\t]");

                for(String dato : datos){
                    System.out.println(dato);
                }
                linea = br.readLine();
            }
        } catch (FileAlreadyExistsException e1) {
            System.out.println("El archivo no se encuentra.");
        } catch(IOException e){
            System.out.println("Error en la entrada/salida");
        }

        try {
            if(br != null) br.close();
            if(fr != null) fr.close();
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }

    }

    public static void añadirFinal(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_2/datos.txt";

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            String linea = "4, Cascos, Periferico, 83, 20";

            bw.write(linea);
            bw.newLine();

        } catch (IOException e1) {
            System.out.println("Error en la entrada / salida");
        }

        try {
            if(bw != null) bw.close();
            if(fw != null) fw.close();
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }
    }

    public static void añadirPrincipio(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_2/datos.txt";

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
           fr = new FileReader(archivo);
           br = new BufferedReader(fr);

           StringBuilder contenidoExistente = new StringBuilder();

            String linea = br.readLine();
            while (linea !=null) {
                contenidoExistente.append(linea).append(System.lineSeparator());
                linea = br.readLine();
            }

            String nuevaLinea = "4, Cascos, Periferico, 83, 20";
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);

            bw.write(nuevaLinea);
            bw.newLine();

            bw.write(contenidoExistente.toString());

        } catch (IOException e1) {
            System.out.println("Error en la entrada / salida");
        }

        try {
            if(bw != null) bw.close();
            if(fw != null) fw.close();
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }
    }

}
