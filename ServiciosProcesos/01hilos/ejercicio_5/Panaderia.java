package programacion_servicios_procesos.hilos01.ejercicio_5;

import java.util.ArrayList;
import java.util.List;

public class Panaderia {
    
    /*Almacen 5 panes
     * panadero produce y guarda
     * almacen lleno = wait
     * clientes consumen pan
     * almacen empty = wait
     */

    private List<Integer> panes = new ArrayList<>();
    private int capacidad = 5;

    public synchronized void producir() throws InterruptedException {
        while (panes.size() == capacidad) {
            wait();
        }
        panes.add(1);
        System.out.println("Panadero introdujo un pan");
        notifyAll();
    }

    public synchronized void consumir(int id) throws InterruptedException {
        while (panes.isEmpty()) {
            wait();
        }
        panes.remove(0);
        System.out.println("Cliente " +id+ " consumio un pan.");
        notifyAll();
    }
}
