package com.rdfj;

import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Main {
    public static void main(String[] args) {
        String servidor = "smtp.gmail.com";
        String emisor = "universaeTest1@gmail.com";   // tu correo
        String contraseña = "tu_contraseña";          // tu contraseña o App Password
        String receptor = "receptoruniversae@gmail.com";
        String receptorCC = "prueba@dominio.com";

        try {
            // Cliente SMTP con TLS
            AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient("TLS", true);
            smtp.setDefaultTimeout(15000);
            smtp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out, true)));

            // Conexión al servidor SMTP de Gmail (puerto 465 = SSL)
            smtp.connect(servidor, 465);
            smtp.ehlo("localhost");  // saludo inicial

            // Autenticación PLAIN
            smtp.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, emisor, contraseña);

            // Configuración emisores y receptores
            smtp.setSender(emisor);
            smtp.addRecipient(receptor);
            smtp.addRecipient(receptorCC);

            // Construcción del mensaje
            String asunto = "Mensaje de prueba";
            String mensaje = "Este es el cuerpo del email";

            SimpleSMTPHeader email = new SimpleSMTPHeader(emisor, receptor, asunto);
            email.addCC(receptorCC);
            email.addHeaderField("Organización", "Universae");

            Writer wr = smtp.sendMessageData();
            if (wr != null) {
                wr.write(email.toString());
                wr.write(mensaje);
                wr.close();
            }

            // Confirmación final
            if (!smtp.completePendingCommand()) {
                System.out.println("El envío ha fallado.");
            } else {
                System.out.println("Email enviado.");
            }

            smtp.logout();
            smtp.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}