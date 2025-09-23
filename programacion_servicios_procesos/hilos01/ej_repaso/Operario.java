package programacion_servicios_procesos.hilos01.ej_repaso;

public class Operario extends Thread {
    public int id;
    public Estacion estacion;

    public Operario(Estacion estacion) {
        this.estacion = estacion;
    }

    @Override
    public void run() {
        try {
            while (true) {
                estacion.liberarCargador();
            }
        } catch (Exception e) {
            System.out.println("Error al lierar un cargador");
        }
    }
}
