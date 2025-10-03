package main;

import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient.AUTH_METHOD;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Main {
    public static void main(String[] args) {
        String servidor = "smtp.gmail.com";
        String emisor = "robertodfj93@gmail.com";
        String password = ""; // Crear contraseña de aplicacion lo probamos y funciona
        String receptor = "paulajuagon2008@gmail.com";
        String receptorCC = "paulajuagon2008@gmail.com";
        
        try {
			AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient("TLS", true);
			smtp.setDefaultTimeout(15000);
			smtp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out, true)));
			
			// Conectamos con el server
			smtp.connect(servidor, 465);
			smtp.ehlo("localhost"); // Linea importante (Saludo inicial)
			
			// Autenticacion
			smtp.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, emisor, password);
			
			// Vinculamos emisor receptor...
			smtp.setSender(emisor);
			smtp.addRecipient(receptor);
			smtp.addRecipient(receptorCC);
			
			// Construimos mensaje
			String asunto = "Paula ponte a estudiar ya";
			String mensaje = "Hola PAULAAA, te envio esto desde el ordenador programando en Java :) Bye... :(";
			
			SimpleSMTPHeader header = new SimpleSMTPHeader(emisor, receptor, asunto);
			header.addCC(receptorCC);
			
			Writer wr = smtp.sendMessageData();
			if(wr != null) {
				wr.write(header.toString());
				wr.write(mensaje);
				wr.close();
			}
			
			// Comprobamos la conexion:
			if(!smtp.completePendingCommand()) {
				System.out.println("Mensaje no enviado, error :(");
			} else {
				System.out.println("Email enviado! :)");
			}
			smtp.logout();
			smtp.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}