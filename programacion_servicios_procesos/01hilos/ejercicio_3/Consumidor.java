package programacion_servicios_procesos.hilos01.ejercicio_3;

public class Consumidor extends Thread{
    private int id;
    private Buffer buffer;

    public Consumidor(int id, Buffer buffer){
        this.id = id;
        this.buffer = buffer;
    }

    // generar buffer
    @Override
    public void run() {
        try {
            while (true) {
                buffer.consumirDato(id);
                sleep(1000); // Simulamos que se consume durmiendo el hilo
            }
        } catch (Exception e) {
            e.setStackTrace(getStackTrace());
        }

    }
}
