package com.rdfj;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.imap.IMAPClient;
import org.apache.commons.net.imap.IMAPSClient;

public class IMAP {
    public static void main(final String[] args) {
        String server = "imap.gmail.com";
        String username = "universaeTest1@gmail.com";  // tu usuario
        String password = "tu_contraseña";             // tu contraseña o App Password
        String protocol = "TLS";

        IMAPClient imap;

        if (protocol != null && protocol.equalsIgnoreCase("TLS")) {
            imap = new IMAPSClient(protocol, true);
        } else {
            imap = new IMAPClient();
        }

        System.out.println("Conectando con el servidor: " + server + " sobre el puerto " + imap.getDefaultPort());

        imap.setDefaultTimeout(60000);
        imap.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out, true)));

        try {
            imap.connect(server);
        } catch (IOException e) {
            throw new RuntimeException("No se puede conectar al servidor", e);
        }

        try {
            if (!imap.login(username, password)) {
                System.err.println("No se puede hacer el login");
                imap.disconnect();
                System.exit(3);
            }

            imap.setSoTimeout(6000);
            imap.capability();
            imap.select("inbox");
            imap.examine("inbox");
            imap.status("inbox", new String[] { "MESSAGES" });

            // Obtiene todos los emails con las fechas internas
            imap.fetch("1:*", "(INTERNALDATE)");

            int numeroEmails = imap.getReplyStrings().length - 1; 
            System.out.println("Fetched " + numeroEmails + " messages via IMAP");

            for (int i = 1; i <= numeroEmails; i++) {
                System.out.println("=========== Inicio mensaje " + i + " ============");
                imap.fetch(String.valueOf(i), "body[header]");
                System.out.println("=========== Fin mensaje " + i + " ============");
                System.out.println();
            }

            // Lista todas las carpetas disponibles
            imap.list("", "*");

            imap.logout();
            imap.disconnect();
        } catch (IOException e) {
            System.out.println(imap.getReplyString());
            e.printStackTrace();
            System.exit(10);
        }
    }
}