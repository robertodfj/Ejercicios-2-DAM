package com.example;

import java.io.File;

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

public class App {
    public static void main(String[] args) {
        File archivo = new File(System.getProperty("user.home") + "/Desktop/ficheros/usuarios.xml");
        leer(archivo);
        escribirXML();
    }

    public static void leer(File archivo) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(archivo);
            document.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());

            // recorrer nodos <usuario>
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
            System.out.println("Error al leer el XML: " + e.getMessage());
        }
    }

    public static void escribirXML(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // Creamos la raiz
            Element root = document.createElement("usuarios");
            document.appendChild(root);

            // Crear usuario dentro de raiz 
            Element usuario = document.createElement("usuario");
            root.appendChild(usuario);

            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode("Juan"));
            usuario.appendChild(nombre);

            Element apellido = document.createElement("apellido");
            apellido.appendChild(document.createTextNode("Perez"));
            usuario.appendChild(apellido);

            Element edad = document.createElement("edad");
            edad.appendChild(document.createTextNode("25"));
            usuario.appendChild(edad);


            // Guardar el documento en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // sangría bonita
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(System.getProperty("user.home") + "/Desktop/ficheros/usuarios2.xml"));

            transformer.transform(source, result);

            System.out.println("✅ Archivo XML creado correctamente.");


        } catch (Exception e) {
            System.out.println("Error al escribir el XML: " + e.getMessage());
        }
    }
}