package programacion_servicios_procesos.hilos01.ejercicio_2;

public class Lectores extends Thread {
    private final int id;
    private Recurso recurso;

    public Lectores(int id, Recurso recurso){
        this.recurso = recurso;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                recurso.EmpezarLeer(id);
                recurso.TerminarLeer(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
