package programacion_servicios_procesos.hilos01.ejercicio_4;

public class CocheB extends Thread {
    private int id;
    private Puente puente;

    public CocheB(int id, Puente puente){
        this.id = id;
        this.puente = puente;
    }

    @Override
    public void run() {
        try {
            while (true) {
                puente.llegaCocheB(id);
                puente.pasarDeBaA();
            }
        } catch (Exception e) {
            e.setStackTrace(getStackTrace());
        }
    }

}
