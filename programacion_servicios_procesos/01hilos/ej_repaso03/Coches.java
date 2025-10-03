public class Coches extends Thread {
    private int id;
    private Parking parking;

    public Coches(int id, Parking parking) {
        this.id = id;
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            while (true) { // ciclo continuo de aparcar y salir
                parking.aparcar(id);

                // simula tiempo estacionado
                Thread.sleep(1000 + (int)(Math.random() * 2000));

                parking.terminar(id);

                // espera antes de intentar aparcar de nuevo
                Thread.sleep(500 + (int)(Math.random() * 1500));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}