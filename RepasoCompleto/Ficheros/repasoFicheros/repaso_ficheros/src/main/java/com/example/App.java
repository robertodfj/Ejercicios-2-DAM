package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App 
{
    public static void main( String[] args )
    {
        // crearXML();
        // leerXML();
        escribirTXT();
        leerTXT();

    }


    // Crear XML
    public static void crearXML(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
            Document document = db.newDocument();
            

            // Crear Raiz
            Element root = document.createElement("usuarios");
            document.appendChild(root);

            // Crear usuario
            Element usuario = document.createElement("usuario");
            root.appendChild(usuario);

            // Nombre usuario
            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode("Juan"));
            usuario.appendChild(nombre);

            // Apellido usuario
            Element apellido = document.createElement("apellido");
            apellido.appendChild(document.createTextNode("Pérez"));
            usuario.appendChild(apellido);
            // Edad usuario
            Element edad = document.createElement("edad");
            edad.appendChild(document.createTextNode("30"));
            usuario.appendChild(edad);

            // Ciudad usuario CP
            Element ciudad = document.createElement("ciudad");
            ciudad.appendChild(document.createTextNode("37300"));
            usuario.appendChild(ciudad);


            // Guardar en fichero
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(System.getProperty("user.home") + "/Desktop/repasoFicheros/usuarios.xml"));
            transformer.transform(domSource, streamResult);

            System.out.println("✅ Archivo XML creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Leer XML
    public static void leerXML(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(System.getProperty("user.home") + "/Desktop/repasoFicheros/usuarios.xml"));

            document.getDocumentElement().normalize();

            NodeList lista = document.getElementsByTagName("usuario");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    System.out.println("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Edad: " + elemento.getElementsByTagName("edad").item(0).getTextContent());
                    System.out.println("------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Escribir fichero texto
    public static void escribirTXT() {
        String ruta = System.getProperty("user.home") + "/Desktop/repasoFicheros/datos.txt";

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            fw = new FileWriter(ruta, true);
            bw = new BufferedWriter(fw);

            StringBuilder builder = new StringBuilder();

            String linea = br.readLine();
            while (linea!= null) {
                builder.append(linea).append(",\t");
                linea = br.readLine();
            }
            String nuevaLinea = "Nueva línea añadida";
            bw.write(nuevaLinea);
            bw.newLine();
            bw.write(builder.toString());
            System.out.println("✅ Fichero escrito correctamente.");


        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Leer fichero texto
    public static void leerTXT() {
        String ruta = System.getProperty("user.home") + "/Desktop/repasoFicheros/datos.txt";

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea!= null) {
                String[] datos = linea.split(",\t");

                for (String dato : datos) {
                    System.out.println(dato);
                }

                linea = br.readLine();
                
            }
        } catch (Exception e) {
            System.out.println("❌ Error al leer el fichero: " + e.getMessage());
        }

    }
}
