package acceso_a_datos.ficheros.ejercicio_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio3 {
    public static void main(String[] args) {
        //mostrar();
        addLine();
    }

    public static void mostrar(){
        FileReader fr = null;
        BufferedReader br = null;

        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_3/datos.txt";

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split("[,\t]");

                for(String dato : datos){
                    System.out.println(dato);
                }

                linea = br.readLine();
            }
            

        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            if(br != null){ br.close();}
            if (fr != null) { fr.close();}
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    public static void addLine(){
        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_3/datos.txt";
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw); 

            String newLine = "10, Sara, Sánchez, Finanzas, 3000.00, 2020-12-20";

            bw.write(newLine);
            bw.newLine();
        } catch (Exception e) {
            // TODO: handle exception
        }

         try {
            if(bw != null){ bw.close();}
            if (fw != null) { fw.close();}
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    public static void addFirstLine(){
        FileReader fr = null;
        FileWriter fw = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        String archivo = System.getProperty("user.home") + "/Documents/Proyectos/DAM_2/acceso_a_datos/ficheros/ejercicio_3/datos.txt";

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            StringBuilder datosExistentes = new StringBuilder();

            String linea = br.readLine();
            while (linea != null) {
                datosExistentes.append(linea).append(System.lineSeparator());
                linea = br.readLine();
            }
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);

            String newLine = "10, Sara, Sánchez, Finanzas, 3000.00, 2020-12-20";

            bw.write(newLine);
            bw.newLine();

            bw.write(datosExistentes.toString());

        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            if(bw != null){ bw.close();}
            if (fw != null) { fw.close();}
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
