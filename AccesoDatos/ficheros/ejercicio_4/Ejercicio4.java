package acceso_a_datos.ficheros.ejercicio_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        //mostrarDatos();
        //añadirFinal();
        añadirPrincipio();
    }

    public static void mostrarDatos(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_3/datos.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);

            String linea = bufferedReader.readLine();
            while (linea != null) {
                String[] datos = linea.split("[,\t]");

                for(String dato : datos){
                    System.out.println(dato);
                }

                linea = bufferedReader.readLine();

            }
        } catch (FileNotFoundException e1) {
            System.out.println("Error, archivo no encontrado.");
        } catch (IOException e){
            System.out.println("Error en la entrada o salida de datos");
        }

        try {
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }
    }

    public static void añadirFinal(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_3/datos.txt";
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(archivo, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            String nuevaLinea = "10, Sara, Sánchez, Finanzas, 3000.00, 2020-12-20";

            bufferedWriter.write(nuevaLinea);
            bufferedWriter.newLine();

            System.out.println("Linea añadida correctamente.");

        } catch (FileNotFoundException e1) {
            System.out.println("Error, archivo no encontrado.");
        } catch (IOException e){
            System.out.println("Error en la entrada o salida de datos");
        }
         try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }
    }

    public static void añadirPrincipio(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_3/datos.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            // Primero leemos y guardamos datos en StringBuilder
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);

            StringBuilder datos = new StringBuilder();
            String linea = bufferedReader.readLine();

            while (linea != null) {
                datos.append(linea).append(System.lineSeparator());
                linea = bufferedReader.readLine();
            }
            // Escribimos lo nuevo + datos
            fileWriter = new FileWriter(archivo);
            bufferedWriter = new BufferedWriter(fileWriter);

            String nuevaLinea = "-1, Sara, Sánchez, Finanzas, 3000.00, 2020-12-20";

            bufferedWriter.write(nuevaLinea);
            bufferedWriter.newLine();

            bufferedWriter.write(datos.toString());

        } catch (FileNotFoundException e1) {
            System.out.println("Error, archivo no encontrado");
        } catch(IOException e){
            System.out.println("Error en la entrada o salida de datos");
        }
        try {
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (Exception e) {
            System.out.println("Error en el cierre");
        }
    }

}
