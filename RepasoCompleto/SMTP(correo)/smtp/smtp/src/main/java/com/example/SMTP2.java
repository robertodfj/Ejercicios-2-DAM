package com.example;

import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class SMTP2 {
    public static void main(String[] args) {
        String servidor = "smtp.gmail.com";
        String emisor = "robertodfj93@gmail.com";
        String password = ""; // Usamos APP pasword
        String receptor = "robertodfj93@gmail.com";

        try {
            AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient("TLS", true);
            smtp.setDefaultTimeout(15000);
            smtp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out, true)));

            // Conectamos con el server
            smtp.connect(servidor, 465);
            smtp.ehlo("localhost"); // Linea importante (Saludo inicial)

            // Vinculamos emisor y receptor
            smtp.setSender(emisor);
            smtp.addRecipient(receptor);

            // Autenticacion
            smtp.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, emisor, password);

            // Construir mensaje
            String asunto = "Correo desde Java - SMTP2";
            String mensaje = "Hola, este correo ha sido enviado desde una aplicacion Java usando Apache - SMTP2";
            SimpleSMTPHeader header = new SimpleSMTPHeader(emisor, receptor, asunto);

            Writer wr = smtp.sendMessageData();

            if (wr != null) {
                wr.write(header.toString());
                wr.write(mensaje);
                wr.close();
            }

            if(smtp.completePendingCommand()){
                System.out.println("Email enviado! :)");
            } else {
                System.out.println("Mensaje no enviado, error :(");
            }

            smtp.logout();
            smtp.disconnect();
        } catch (Exception e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}
