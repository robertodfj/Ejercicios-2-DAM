package programacion_servicios_procesos.hilos01.ejercicio_2;

public class Escritores extends Thread{
    private final int id;
    private Recurso recurso;

    public Escritores(int id, Recurso recurso){
        this.recurso = recurso;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                recurso.EmpezarEscribit(id);
                recurso.TerminarEscribir(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
