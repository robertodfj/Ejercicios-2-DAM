package programacion_servicios_procesos.hilos01.ej_repaso;

import java.util.ArrayList;
import java.util.List;

public class Estacion {
    public int cargadores = 5;
    public List<Integer> vehiculos = new ArrayList<>();

    public synchronized void cargarVehiculo(int id) throws InterruptedException{
        while (vehiculos.size() >= cargadores) {
            wait();
        }
        vehiculos.add(id);
        notifyAll();
        System.out.println("Vehiculo " +id+ " empieza a cargar");
    }

    public synchronized void liberarCargador() throws InterruptedException{
        while (vehiculos.isEmpty()) {
            wait();
        }
        int id = vehiculos.remove(0);
        notifyAll();
        System.out.println("Vehiculo " +id+ " termina de cargar");
    }
}
