package programacion_servicios_procesos.hilos01.ejercicio_4;

public class CocheA extends Thread {
    private int id;
    private Puente puente;

    public CocheA(int id, Puente puente){
        this.id = id;
        this.puente = puente;
    }

    @Override
    public void run() {
        try {
            while (true) {
                puente.llegaCocheA(id);
                puente.pasarDeAaB();
            }
        } catch (Exception e) {
            e.setStackTrace(getStackTrace());
        }
    }

}
