package programacion_servicios_procesos.hilos01.ejercicio_5;

public class Panadero extends Thread {
    private int id;
    private Panaderia panaderia;

    public Panadero(int id, Panaderia panaderia){
        this.id = id;
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                panaderia.producir();
                sleep((long)Math.random()*1000);
            }
        } catch (Exception e) {
            e.setStackTrace(getStackTrace());
        }
    }
}
