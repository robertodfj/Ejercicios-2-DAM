package programacion_servicios_procesos.hilos01.ejercicio_1;

public class Mesa {

    private boolean tenedores[];

    public Mesa(int numeroTenedores){
        this.tenedores = new boolean[numeroTenedores];
    }

    public int tenedorIzquierdo(int posicion){
        return posicion;
    }

    public int tenedorDerecha(int posicion){
        if (posicion == 0) {
            return tenedores.length -1;
        }
        return posicion;
    }

    // cogemos los 2, el primero que llega en vez de separar los metodos
    public synchronized void cogerTenedores(int idFilosofo){
        while (tenedores[tenedorIzquierdo(idFilosofo)] || tenedores[tenedorDerecha(idFilosofo)]) {
            try {
                // esperar
                wait();
        
            } catch (Exception e) {
                // TODO: handle exception
            }
            tenedores[tenedorIzquierdo(idFilosofo)] = true;
            tenedores[tenedorDerecha(idFilosofo)] = true;
        }
    }


    public synchronized void dejarTenedores(int idFilosofo){

        tenedores[tenedorIzquierdo(idFilosofo)] = false;
        tenedores[tenedorDerecha(idFilosofo)] = false;

        notifyAll();

    }

}