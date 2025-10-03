package smtp;

import java.io.Writer;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient.AUTH_METHOD;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Main {
	public static void main(String[] args) {
		String servidor = "";
		String receptor = "";
		String password = "";
		String emisor = "";
		
		try {
			AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient("TLS", true);
			smtp.setDefaultTimeout(2000);
			
			smtp.connect(servidor, 465);
			smtp.ehlo("localhost");
			
			smtp.auth(AUTH_METHOD.PLAIN, emisor, password);
			
			smtp.setSender(emisor);
			smtp.addRecipient(receptor);
			
			String asunto = "Ejercicio 3";
			String mensaje = "Mensaje ejercicio 3";
			
			SimpleSMTPHeader header = new SimpleSMTPHeader(emisor, receptor, asunto);
			
			Writer wr = smtp.sendMessageData();
			if (wr != null) {
				wr.write(header.toString());
				wr.write(mensaje);
				wr.close();
			}
			
			if (!smtp.completePendingCommand()) {
				System.out.println("Error al enviar");
			} else {
				System.out.println("Mensaje enviado");
			}
			
			smtp.logout();
			smtp.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
