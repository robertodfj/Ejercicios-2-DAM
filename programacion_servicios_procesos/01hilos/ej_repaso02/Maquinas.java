
public class Maquinas {
    public int maquinasLibres = 5;
    public boolean limpiando = false;

    public synchronized void entrenar(int id) throws InterruptedException{
        while (maquinasLibres == 0 || limpiando) { 
            // Espera para entrenar si esta limpiando o no esta libre
            wait();
        }
        System.out.println("Deportista entrena");
        maquinasLibres --;
        Thread.sleep(2000);

        System.out.println("Deportista acaba");
        maquinasLibres++;
        notifyAll();
        
    }

    public synchronized void limpiar() throws InterruptedException{
        while(maquinasLibres < 5){
            wait();
        }
        System.out.println("Limpiando gym...");
        limpiando = true;
        Thread.sleep(2000);

        System.out.println("Limpiador acaba de limpiar");
        limpiando = false;
        notifyAll();

    }
}


