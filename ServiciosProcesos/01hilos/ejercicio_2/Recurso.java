package programacion_servicios_procesos.hilos01.ejercicio_2;

public class Recurso {
    private int lectores = 0;

    // Leer
    public synchronized void EmpezarLeer(int idLector) throws InterruptedException{
        while (lectores < 0) {
            wait();
        }
        lectores++;
        System.out.println("El lector " +idLector+ " empezo a leer.");
    }

    public synchronized void TerminarLeer(int idLector){
        lectores--;
        System.out.println("El lector " +idLector+ " acabo de leer.");
        notifyAll();
    }

    // Escribir
    public synchronized void EmpezarEscribit(int idEscritor) throws InterruptedException{
        while (lectores != 0) {
            wait();
        }
        lectores = -1;
        System.out.println("El escritor " +idEscritor+ " empezo de escribir.");
    }

    public synchronized void TerminarEscribir(int idEscritor){
        lectores = 0;
        System.out.println("El escritor " +idEscritor+ " acabo de escribir.");
        notifyAll();
    }

}
