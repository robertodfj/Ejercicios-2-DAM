package programacion_servicios_procesos.hilos01.ejercicio_5;

public class Main {
    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();

        for (int i = 0; i < 1; i++) {
            Panadero panadero = new Panadero(i, panaderia);
            panadero.start();
        }

        for (int i = 0; i < 5; i++) {
            Clientes clientes = new Clientes(i, panaderia);
            clientes.start();
        }
    }
}
