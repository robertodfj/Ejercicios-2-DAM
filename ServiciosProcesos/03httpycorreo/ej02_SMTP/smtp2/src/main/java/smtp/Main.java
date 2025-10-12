package smtp;

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
		String password = "";
		String receptor = "paulajuagon2008@gmail.com";
		
		try {
			AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient("TLS", true);
			smtp.setDefaultTimeout(20000);
			
			smtp.connect(servidor, 465);
			smtp.ehlo("localhost");
			
			smtp.auth(AUTH_METHOD.PLAIN, emisor, password);
			
			smtp.setSender(emisor);
			smtp.addRecipient(receptor);
			
			String asunto = "Hola";
			String mensaje = "Hola esta es la prueba del ej2";
			
			SimpleSMTPHeader header = new SimpleSMTPHeader(emisor, receptor, asunto);
			
			Writer wr = smtp.sendMessageData();
			if (wr != null) {
				wr.write(header.toString());
				wr.write(mensaje);
				wr.close();
			}
			
			if (!smtp.completePendingCommand()) {
				System.out.println("Error en el envio de email.");
			} else {
				System.out.println("Correo enviado de forma correcta.");
			}
			
			smtp.logout();
			smtp.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
