package programacion_servicios_procesos.hilos01.ejercicio_1;

public class Main {
    public static void main(String[] args) {
        int numeroTenedores = 5;
        int numeroFilosofos = 5;

        Mesa mesa = new Mesa(numeroTenedores);

        for (int i = 0; i < numeroFilosofos; i++) {
            Filosofo filosofo = new Filosofo(mesa, i);
            filosofo.start();
        }
    }
}
