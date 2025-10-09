package xmlCreateFile;

import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			
			// Crear documento
			Document doc = dbBuilder.newDocument();
			Element root = doc.createElement("Empresas");
			doc.appendChild(root);
			
			// Metemos cosas dentro de la raiz
			for (int i = 0; i < 3; i++) {
				Element empresa = doc.createElement("Nombre");
				empresa.setAttribute("CIF", "C" +i);
				
				Element empleado = doc.createElement("Empleados");
				Element codigo = doc.createElement("Codigo");
				codigo.setTextContent("000" +i);
				empleado.appendChild(codigo);
				empresa.appendChild(empleado);
				
				root.appendChild(empresa);
			}
			
			// Serializacion
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			
			DOMSource domSource = new DOMSource(doc);
			StreamResult result = new StreamResult("src/main/java/xmlCreateFile/empresas.xml");
			
			transformer.transform(domSource, result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
