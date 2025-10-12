public class Deportista extends Thread {
    private int id;
    private Maquinas gym;

    public Deportista(int id, Maquinas gym) {
        this.id = id;
        this.gym = gym;
    }

    @Override
    public void run() {
        try {
            while (true) { // el deportista sigue entrenando en bucle
                gym.entrenar(id);
                Thread.sleep(1000); // descansa un poco antes de volver a entrenar
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}