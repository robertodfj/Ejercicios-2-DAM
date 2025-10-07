package ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Properties;

public class Gestor {

    public boolean crearUsuarios(String usuario, String contraseña) {
        try {
            File archivo = new File("usuarios.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            Properties propiedades = new Properties();
            try (FileInputStream entrada = new FileInputStream(archivo)) {
                propiedades.load(entrada);
            }

            String algoritmo = "SHA-256";
            String hashContraseña = cifrar(contraseña, algoritmo);
            propiedades.setProperty(usuario, hashContraseña);

            // Guardar los cambios
            try (FileOutputStream salida = new FileOutputStream(archivo)) {
                propiedades.store(salida, "Usuarios y contraseñas cifradas");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String usuario, String contraseña) {
        try {
            Properties propiedades = new Properties();
            try (FileInputStream entrada = new FileInputStream("usuarios.txt")) {
                propiedades.load(entrada);
            }

            String contraseñaAlmacenada = propiedades.getProperty(usuario);
            if (contraseñaAlmacenada == null) {
                return false;
            }

            String algoritmo = "SHA-256";
            String contraseñaIntroducida = cifrar(contraseña, algoritmo);

            return contraseñaAlmacenada.equals(contraseñaIntroducida);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String cifrar(String datos, String algoritmo) {
        try {
            byte[] datosBytes = datos.getBytes();
            MessageDigest digest = MessageDigest.getInstance(algoritmo);
            byte[] hash = digest.digest(datosBytes);

            StringBuilder hexadecimal = new StringBuilder();
            for (byte b : hash) {
                hexadecimal.append(String.format("%02x", b));
            }

            return hexadecimal.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}