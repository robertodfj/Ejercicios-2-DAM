package com.example;

public class Estacion {

    int puestosLibres = 5;

    public synchronized void limpiarCoche(Clientes clientes) throws InterruptedException{
        while (puestosLibres == 0) { 
            wait();
        }
        puestosLibres--;
        notifyAll();
        System.out.println("El coche "+clientes.getNum()+" empieza a limpiarse");
    }
    public synchronized void terminar(Empleados empleados) throws InterruptedException{
        while (puestosLibres == 5) { 
            wait();
        }
        puestosLibres++;
        System.out.println("El empleado " +empleados.getNum()+" libera un puesto");
        notifyAll();
    }
}
