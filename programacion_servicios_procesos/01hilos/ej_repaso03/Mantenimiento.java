public class Mantenimiento extends Thread {
    private Parking parking;
    private int id;

    public Mantenimiento(int id, Parking parking) {
        this.id = id;
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Espera un tiempo antes de la siguiente revisión
                Thread.sleep(5000 + (int)(Math.random() * 5000));
                
                System.out.println("Mantenimiento " + id + " va a revisar el parking...");
                parking.revisar(id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}