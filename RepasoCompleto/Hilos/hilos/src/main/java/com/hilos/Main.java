package com.hilos;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        for (int i = 0; i < 6; i++) {
            Cliente c = new Cliente(i, banco);
            c.start();
        }
    }
}
