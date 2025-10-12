package programacion_servicios_procesos.hilos01.ejercicio_4;

import java.util.ArrayList;
import java.util.List;

public class Puente {

    private List<Integer> cochesA = new ArrayList<>();
    private List<Integer> cochesB = new ArrayList<>();
    private String direccion = "NINGUNA";

    public synchronized void llegaCocheA(int id) {
        cochesA.add(id);
        System.out.println("Llega coche " + id + " a A");
        notifyAll(); 
    }   

    public synchronized void llegaCocheB(int id) {
        cochesB.add(id);
        System.out.println("Llega coche " + id + " a B");
        notifyAll(); 
    }
    

    // Pasar los coches de A -----> B
    public synchronized void pasarDeAaB() throws InterruptedException{
        while (cochesA.isEmpty() || direccion.equals("B")) {
            wait();
        }
        direccion = "A";
        int cantidad = Math.min(3, cochesA.size());
        cochesA.subList(0,  cantidad).clear();
        System.out.println("Pasan " +cantidad+ " coches de A ---> B");
        direccion = "NINGUNA";
        notifyAll();
    }

    // Pasar los coches de B -----> A
    public synchronized void pasarDeBaA() throws InterruptedException{
        while (cochesB.isEmpty() || direccion.equals("A")) {
            wait();
        }
        direccion = "B";
        int cantidad = Math.min(3, cochesB.size());
        cochesB.subList(0,  cantidad).clear();
        System.out.println("Pasan " +cantidad+ "coches de B ---> A");
        direccion = "NINGUNA";
        notifyAll();
    }

}

    