package tomcat;

import org.apache.catalina.startup.Tomcat;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // Necesario para inicializar el conector
        tomcat.getConnector();

        // Ruta al directorio webapp
        String webappDir = new File("src/main/webapp").getAbsolutePath();
        tomcat.addWebapp("/", webappDir);

        // Inicia Tomcat
        tomcat.start();
        tomcat.getServer().await();
    }
}