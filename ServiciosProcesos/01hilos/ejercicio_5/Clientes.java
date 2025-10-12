package programacion_servicios_procesos.hilos01.ejercicio_5;

public class Clientes extends Thread {
    private int id;
    private Panaderia panaderia;

    public Clientes(int id, Panaderia panaderia){
        this.id = id;
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                panaderia.consumir(id);
            }
        } catch (Exception e) {
            e.setStackTrace(getStackTrace());
        }
    }

}
