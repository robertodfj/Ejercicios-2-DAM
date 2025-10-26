package com.example;

import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;
public class App 
{
    public static void main( String[] args )
    {
        // Elementos necesarios para enviar un correo
        String servidor = "smtp.gmail.com";
        String emisor = "robertodfj93@gmail.com";
        String password = ""; // Usamos APP pasword (Borrada para realizar commit)
        String receptor = "paulajuagon2008@gmail.com";

        try {
            // Iniciamos SMTP
            AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient("TLS", true);
			smtp.setDefaultTimeout(15000);
			smtp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out, true)));
			
			// Conectamos con el server
			smtp.connect(servidor, 465);
			smtp.ehlo("localhost"); // Linea importante (Saludo inicial)
			
			// Autenticacion
			smtp.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, emisor, password);

            // Vinculamos emisor y receptor
            smtp.setSender(emisor);
            smtp.addRecipient(receptor);
            

            // Construimos mensaje
            String asunto = "Correo desde Java";
            String mensaje = "Hola, este correo ha sido enviado desde una aplicacion Java usando Apache";
            SimpleSMTPHeader header = new SimpleSMTPHeader(emisor, receptor, asunto);

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

            // Cerrar conexion
            smtp.logout();
            smtp.disconnect();
                
			
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
