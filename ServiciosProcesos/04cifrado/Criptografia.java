
import java.security.MessageDigest;

public class Criptografia {
    public static void main(String[] args) {
        String datos = "Mensaje de prueba";
        String algoritmo = "SHA-256";

        try {
            byte[] datosEnBytes = datos.getBytes();
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(datosEnBytes);
            byte[] hash = md.digest();

            String hexadecimal = " ";

            for (byte b : hash) {
                hexadecimal += String.format(String.format("%x", b));
            }

            System.out.println("Valor hash: " +hexadecimal);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
