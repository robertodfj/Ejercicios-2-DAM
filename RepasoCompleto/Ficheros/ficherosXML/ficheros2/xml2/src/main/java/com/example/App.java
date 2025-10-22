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

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // Escribir archivo XML
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // Crear el elemento raíz
            Element root = doc.createElement("usuarios");
            doc.appendChild(root);

            // Crear elementos hijos
            Element usuario = doc.createElement("usuario");
            root.appendChild(usuario);

            // Crear subelementos
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("Juan"));
            usuario.appendChild(nombre);

            Element apellido = doc.createElement("apellido");
            apellido.appendChild(doc.createTextNode("Muñoz"));
            usuario.appendChild(apellido);


            // Guardar el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // sangría bonita
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(System.getProperty("user.home") + "/Desktop/ficheros2/usuarios2.xml"));

            transformer.transform(source, result);

            System.out.println("✅ Archivo XML creado correctamente.");

        } catch (Exception e) {
            System.out.println("❌ Error al crear el archivo XML: " + e.getMessage());
        }

    }
}
