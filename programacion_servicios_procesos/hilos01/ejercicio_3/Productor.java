package programacion_servicios_procesos.hilos01.ejercicio_3;

public class Productor extends Thread {
    private int id;
    private Buffer buffer;

    public Productor(int id, Buffer buffer){
        this.id = id;
        this.buffer = buffer;
    }

    // generar buffer
    @Override
    public void run() {
        try {
           while (true) {
                int valor = (int)(Math.random()*100);
                buffer.generarDato(valor, id);
                sleep(1000); // Simulamos que se genera esperando - durmiendo el hilo
           }
        } catch (Exception e) {
            e.setStackTrace(getStackTrace());
        }
    }
}
