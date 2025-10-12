
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class ClienteHttp {

    public static void main(String[] args) {
        String direccion = "https://es.wikipedia.org/";

        try {
            URL url = new URL(direccion);
            URLConnection conexion = url.openConnection();

             // User-Agent para que el servidor no bloquee
            conexion.setRequestProperty("User-Agent", 
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Java/ClienteHttp");

            // Respuesta
            System.out.println("Codigo respuesta: " + ((HttpURLConnection)conexion).getResponseCode());
            System.out.println("Codificacion: " + conexion.getContentEncoding());
            System.out.println("Longitud: " + conexion.getContentLength());
            System.out.println("Fecha: " + (new SimpleDateFormat("dd/MM/yy")).format(conexion.getDate()));
            System.out.println("Fecha Expiracion: " + (new SimpleDateFormat("dd/MM/yy")).format(conexion.getExpiration()));
        
            // Cabecera 
            Map<String, List<String>> headers = conexion.getHeaderFields();
            Iterator<Map.Entry<String, List<String>>> iterator = headers.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, List<String>> header = iterator.next();
                System.out.println(header.getKey()+ ":[");
                List<String> valor = header.getValue();
                for (String string : valor) {
                    System.out.println(string+ " ");
                }
                System.out.println("]");
                
            }

            // Cuerpo
            InputStream is = conexion.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linea = br.readLine();
            String contenido = "";

            while (linea != null) { 
                System.out.println(linea);
                contenido +=linea;
                linea = br.readLine();
            }

            generaInterfaz(contenido);

            br.close();
            isr.close();
            is.close();
        
        } catch (Exception e) {
            System.out.println("Error en la conexxion HTTP: " +e.getStackTrace());
        }
    }

    public static  void generaInterfaz(String contenido){
        JFrame frame = new JFrame("Navegador");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setContentType("text/html");
        jEditorPane.setText(contenido);
        jEditorPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(jEditorPane);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}