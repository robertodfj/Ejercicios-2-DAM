
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP{
    public static void main(String[] args) throws  IOException{
        int puerto = 8866;
        InetAddress ipServidor = InetAddress.getByName("localhost");

        // socket cliente
        DatagramSocket socket = new DatagramSocket();

        // mensaje a enviar
        String message = "Hola servidor, que hora tienes?";
        byte[] buffer = message.getBytes();

        // Paquete a enviar
        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, ipServidor, puerto);
        socket.send(paquete);
        System.out.println("Mensaje enviado al servidor: " +message);

        // Esperar respuesta servidor
        byte[] bufferRespuesta = new byte[1024];
        DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
        socket.receive(paqueteRespuesta);

        // Mostar respuesta
        String messageResponse = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());
        System.out.println("Respuesta servidor: " +messageResponse);

        socket.close();



    }
}