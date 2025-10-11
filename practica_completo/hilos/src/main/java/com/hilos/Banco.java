package com.hilos;

public class Banco {
    int cajeros = 3;

    public synchronized void usarCajero(Cliente cliente) throws InterruptedException{
        while (cajeros== 0) { 
            wait();
        }
        cajeros--;
        System.out.println("El cliente " +cliente.getNumero()+ " empieza a usar el cajero");
    }

    public synchronized void terminarUso(Cliente cliente) throws InterruptedException{
        cajeros++;
        System.out.println("El cliente " +cliente.getNumero()+ " termina de usar el cajero");
        notifyAll();
    }
}
