
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente2UDP {
    public static void main(String[] args) throws IOException {
        int puerto = 9000;
        InetAddress ip = InetAddress.getByName("localhost");
        Scanner scanner = new Scanner(System.in);

        DatagramSocket socket = new DatagramSocket();

        while (true) { 
            System.out.println("Intoduce un dato");
            String message = scanner.nextLine();
            byte[] sms = message.getBytes();

            DatagramPacket packet = new DatagramPacket(sms, sms.length, ip, puerto);
            socket.send(packet);

            // server response
            byte[] response = new byte[1024];
            DatagramPacket serverPacket = new DatagramPacket(response, response.length);
            socket.receive(serverPacket);

            String serverResponse = new String(serverPacket.getData(), 0, serverPacket.getLength());
            System.out.println(serverResponse);

            if (message.equalsIgnoreCase("adios")) {
                System.out.println("Conexión finalizada.");
                break;
            }
        }
        socket.close();
        scanner.close();
    }
}
