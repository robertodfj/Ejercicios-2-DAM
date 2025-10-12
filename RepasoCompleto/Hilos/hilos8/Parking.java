public class Parking {
    public int plazasLibres = 100;
    public boolean revision = false;

    public synchronized void aparcar(int id) throws InterruptedException{
        while (plazasLibres == 0 || revision) { 
            wait();
        }
        System.out.println("El coche " +id+ " aparca");
        plazasLibres--;
    }
    public synchronized void terminar(int id) throws InterruptedException{
        while (revision) { 
            wait();
        }
        System.out.println("El coche " +id+ " sale del parking");
        plazasLibres++;
        notifyAll();
    }
    public synchronized void revisar(int id) throws InterruptedException{
        System.out.println("Se procede a revisar el parking");
        revision = true;
        Thread.sleep(2000);

        System.out.println("Revision terminada");
        revision = false;
        notifyAll();
        
    }
}
