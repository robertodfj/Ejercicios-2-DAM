package com.hilos;

public class Cliente extends Thread {

    int id;
    Banco banco;

    public Cliente(int i, Banco banco) {
        this.id = i;
        this.banco = banco;
    }

    public int getNumero() {
        return id;
    }

    public void setNumero(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            banco.usarCajero(this);
            sleep((int) (Math.random()*1000));
            banco.terminarUso(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
