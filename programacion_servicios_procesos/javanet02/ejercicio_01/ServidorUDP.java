
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        int tamaño = 1024;
        int puerto = 8866;
        byte[] sms = new byte[tamaño];

        int randomNumber = (int)(Math.random()*10);
        
        // Creamos el socket servidor
        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.println("Servidor activo.");

        // Recibir peticion
        while (true) { 
            DatagramPacket clientPacket = new  DatagramPacket(new byte[tamaño], tamaño);
            socket.receive(clientPacket);
            System.out.println("Peticion recibida de ip: " + clientPacket.getAddress());
            // Leer numero del cliente
            String clientMessage = new String(clientPacket.getData(), 0, clientPacket.getLength());
            int clientNumber = Integer.parseInt(clientMessage.trim());
            // Generar un numero aleatorio
            if (clientNumber == randomNumber) {
                String respuesta = "Premio! el numero era " +randomNumber;
                sms = respuesta.getBytes();
            } else if (clientNumber < randomNumber) {
                String respuesta = "El numero es mayor";
                sms = respuesta.getBytes();
            } else {
                String respuesta = "El numero es menor";
                sms = respuesta.getBytes();
            }

            DatagramPacket packet = new DatagramPacket(sms, sms.length, clientPacket.getAddress(), clientPacket.getPort());
            socket.send(packet);

        }

    }
}
