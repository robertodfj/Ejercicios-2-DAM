
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class ServidorUDP{
    public static void main(String[] args) throws  IOException{
        int tamaño = 1024;
        int puerto = 8866;
        byte sms[] = new byte[tamaño];

        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.println("Servidor activo.");

        while (true) { 
            DatagramPacket recibido = new DatagramPacket(new byte[tamaño], tamaño);
            socket.receive(recibido);
            System.out.println("Ha llegado una peticion");
            System.out.println("Procede de la IP: " +recibido.getAddress());
            System.out.println("A traver del puerto: " +recibido.getPort());
            String message = new String("Hora del servidor: " + new Date());
            sms = message.getBytes();
            DatagramPacket paquete = new DatagramPacket(sms, sms.length, recibido.getAddress(), recibido.getPort());
            socket.send(paquete);
        }
    }


}