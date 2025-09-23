package programacion_servicios_procesos.hilos01.ejercicio_1;

public class Filosofo extends Thread{
    private Mesa mesa;
    private int id;

    public Filosofo(Mesa mesa, int id){
        this.mesa = mesa;
        this.id = id;
    }

    @Override
    public void run(){

        while (true) {
            piensa();
            come();
        }

    }

    public void piensa(){
        System.out.println("El filosofo " +id+ " comienza a pensar");

        try {
            sleep((long)(Math.random() * 10000));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("El filosofo " +id+ " termina de pensar");
    }

    public void come(){

        mesa.cogerTenedores(id);
        System.out.println("El filosofo " +id+ " coge tenedor izquierda");
        System.out.println("El filosofo " +id+ " coge tenedor derecha");

        System.out.println("El filosofo " +id+ " comienza a comer");


        try {
            sleep((long)(Math.random() * 10000));
        } catch (Exception e) {
            e.printStackTrace();
        }


        mesa.dejarTenedores(id);
        System.out.println("El filosofo " +id+ " deja los tenedores");
        System.out.println("El filosofo " +id+ " termina de comer");
    }


}
