
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor2UDP {
    public static void main(String[] args) throws IOException {
        int puerto = 9000;
        int tamaño = 1024;
        byte[] sms = new byte[tamaño];
        Boolean running = true;

        // Crear el socket
        DatagramSocket serverSocket = new DatagramSocket(puerto);
        System.out.println("Servidor activo");

        // Esperar respuesta
        while (running) { 
            DatagramPacket packet = new DatagramPacket(sms, sms.length);
            serverSocket.receive(packet);
            System.out.println("Peticion recibida de la ip: " +packet.getAddress());
            String data = new String(packet.getData(), 0, packet.getLength()).toUpperCase();
       
            // Respuesta del servidor
            String message;
            if (data.contains("ADIOS")) {
                message = "Hasta luego!";
                running = false;
            } else{
                message = "Mensaje recibido: " +data;
            }

            sms = message.getBytes();
            DatagramPacket serverPacket = new DatagramPacket(sms, sms.length, packet.getAddress(), packet.getPort());
            serverSocket.send(serverPacket);
        }
        serverSocket.close();
    }
}
