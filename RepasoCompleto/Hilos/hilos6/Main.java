package programacion_servicios_procesos.hilos01.ej_repaso;

public class Main {
    public static void main(String[] args) {
         Estacion estacion = new Estacion();

        // Lanzar 10 vehículos
        for (int i = 1; i <= 10; i++) {
            new Vehiculo(i, estacion).start();
        }

        // Lanzar 3 operarios
        for (int i = 1; i <= 3; i++) {
            new Operario(estacion).start();
        }
    }
}
