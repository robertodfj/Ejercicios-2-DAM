public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();

        // Crear y lanzar coches
        for (int i = 1; i <= 10; i++) { // por ejemplo 10 coches
            new Coches(i, parking).start();
        }

        // Crear y lanzar hilo de mantenimiento
        new Mantenimiento(1, parking).start();
    }
}