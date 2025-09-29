package programacion_servicios_procesos.hilos01.ejercicio_4;


public class Main {
    public static void main(String[] args) {
        Puente puente = new Puente();

        for (int i = 0; i < 3; i++) {
                CocheA cocheA = new CocheA(i, puente);
                cocheA.start();
            }

        for (int i = 0; i < 3; i++) {
                    CocheB cocheB = new CocheB(i, puente);
                    cocheB.start();
        }
    }

}
