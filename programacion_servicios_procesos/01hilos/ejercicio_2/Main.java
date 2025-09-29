package programacion_servicios_procesos.hilos01.ejercicio_2;

public class Main {
    
    public static void main(String[] args) {
        Recurso recurso = new Recurso();
        for (int i = 0; i < 2; i++) {
            Lectores lectores = new Lectores(i, recurso);
            lectores.start();
        }

        for (int i = 0; i < 3; i++) {
            Escritores escritores = new Escritores(i, recurso);
            escritores.start();
        }
    }
}
