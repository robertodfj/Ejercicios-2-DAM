package programacion_servicios_procesos.hilos01.ej_repaso;

public class Vehiculo extends Thread{
    public int id;
    public Estacion estacion;

    public Vehiculo(int i, Estacion estacion) {
        this.id = i;           
        this.estacion = estacion;
    }

    @Override
    public void run() {
        try {
            while (true) {
                estacion.cargarVehiculo(id);
                sleep((long) (Math.random()*1000));
            }
        } catch (Exception e) {
            System.out.println("Error al cargar vehiculo");
        }
    }
}
