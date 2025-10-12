package programacion_servicios_procesos.hilos01.ejercicio_3;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private int capacidad = 5;
    private List<Integer> cola = new ArrayList<>();

    public synchronized void generarDato(int valor, int idProductor) throws InterruptedException{
        while (capacidad <= cola.size()) {
            wait();
        }
        cola.add(valor);
        notifyAll();
        System.out.println("El productor " +idProductor+ " produjo el valor: " +valor);
    }

    public synchronized void consumirDato(int idConsumidor) throws InterruptedException{
        while (cola.isEmpty()) {
            wait();
        }
        cola.remove(0);
        notifyAll();
        System.out.println("El consumidor " +idConsumidor+ " consumio el valor");
    }
}
