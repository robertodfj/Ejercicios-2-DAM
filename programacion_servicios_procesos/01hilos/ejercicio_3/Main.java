package programacion_servicios_procesos.hilos01.ejercicio_3;

public class Main {
    
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        for (int i = 0; i < 3; i++) {
            Productor productor = new Productor(i, buffer);
            productor.start();
        }

        for (int i = 0; i < 3; i++) {
            Consumidor consumidor = new Consumidor(i, buffer);
            consumidor.start();
        }
    }

}
