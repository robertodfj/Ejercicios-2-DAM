package com.example;

import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient.AUTH_METHOD;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class App 
{
    public static void main( String[] args )
    {
        String servidor = "smtp.gmail.com";
        String emisor = "robertodfj93@gmail.com";
        String receptor = "robertodfj93@gmail.com";

        AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient("TLS", true);
        smtp.setDefaultTimeout(15000);
        smtp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out, true)));

        smtp.connect(servidor, 465);
        smtp.ehlo("localhost");

        smtp.auth(AUTH_METHOD.PLAIN, emisor, "your_app_password_here");

        smtp.setSender(emisor);
        smtp.addRecipient(receptor);

        String asunto = "Test Email";
        String mensaje = "This is a test email sent from a Java application.";

        SimpleSMTPHeader header = new SimpleSMTPHeader(emisor, receptor, asunto);
        try {
            Writer wr = smtp.sendMessageData();
            if(wr != null) {
                wr.write(header.toString());
                wr.write(mensaje);
                wr.close();
            }

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
