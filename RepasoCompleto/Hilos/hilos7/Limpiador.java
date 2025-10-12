public class Limpiador extends Thread {
    private Maquinas gym;

    public Limpiador(Maquinas gym) {
        this.gym = gym;
    }

    @Override
    public void run() {
        try {
            while (true) { // el limpiador también sigue trabajando en bucle
                gym.limpiar();
                Thread.sleep(5000); // espera un rato antes de volver a limpiar
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}