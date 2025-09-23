
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        int puerto = 8866;
        int tamaño = 1024;

        // Creamos el socket servidor
        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.println("Servidor activo en el puerto " + puerto);

        // Generamos un número aleatorio entre 0 y 9
        int randomNumber = (int)(Math.random() * 10);
        System.out.println("Número a adivinar generado: " + randomNumber);

        while (true) {
            try {
                // Preparar buffer para recibir datos del cliente
                byte[] buffer = new byte[tamaño];
                DatagramPacket clientPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(clientPacket);

                InetAddress clienteIP = clientPacket.getAddress();
                int clientePuerto = clientPacket.getPort();

                // Convertir el mensaje del cliente a número
                String clientMessage = new String(clientPacket.getData(), 0, clientPacket.getLength()).trim();
                int clientNumber;
                try {
                    clientNumber = Integer.parseInt(clientMessage);
                } catch (NumberFormatException e) {
                    String errorMsg = "Por favor envía un número válido del 0 al 9";
                    byte[] errorBytes = errorMsg.getBytes();
                    DatagramPacket errorPacket = new DatagramPacket(errorBytes, errorBytes.length, clienteIP, clientePuerto);
                    socket.send(errorPacket);
                    continue; // Volver a esperar otro mensaje
                }

                // Preparar la respuesta
                String respuesta;
                if (clientNumber == randomNumber) {
                    respuesta = "¡Premio! El número era " + randomNumber;
                } else if (clientNumber < randomNumber) {
                    respuesta = "El número es mayor que " + clientNumber;
                } else {
                    respuesta = "El número es menor que " + clientNumber;
                }

                // Enviar respuesta al cliente
                byte[] respuestaBytes = respuesta.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(respuestaBytes, respuestaBytes.length, clienteIP, clientePuerto);
                socket.send(responsePacket);
                socket.close();

            } catch (IOException e) {
                System.err.println("Error en la comunicación: " + e.getMessage());
            }
        }
        
    }
}
