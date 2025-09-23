
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        int puerto = 8866;
        InetAddress ip = InetAddress.getByName("localhost");
        Scanner scanner = new Scanner(System.in);
        boolean adivinado = false;

        DatagramSocket socket = new DatagramSocket();

        // Enviar mensaje

        while (!adivinado) { 
            String introduce = "Introduce un nuevo del 0 al 9";
            System.out.println(introduce);
            int message = scanner.nextInt();
            byte[] buffer = String.valueOf(message).getBytes();

            // Enviar al servidor
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip, puerto);
            socket.send(packet);

            // respuesta
            byte[] bufferResponse = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(bufferResponse, bufferResponse.length);
            socket.receive(responsePacket);

            String serverResponese = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(serverResponese);

            if (serverResponese.contains("mayor")) {
                introduce = "Introduce un numero mayor que " +message;
            } else if (serverResponese.contains("menor")) {
                introduce = "Introduce un numero menor que " +message;
            } else if (serverResponese.startsWith("Premio")) {
                adivinado = true;
            }

            if (!adivinado) {
                System.out.println(introduce);
            }
            
        }
        
        
    }
}