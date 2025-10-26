package com.example;

import java.io.PrintWriter;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
public class App 
{
    public static void main( String[] args )
    {
        // Elementos necesarios para enviar un correo
        String servidor = "smtp.gmail.com";
        String emisor = "robertodfj93@gmail.com";
        String password = ""; // Usamos APP pasword
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
			
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
