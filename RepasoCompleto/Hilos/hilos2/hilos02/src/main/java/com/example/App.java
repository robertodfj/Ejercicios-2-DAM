package com.example;

public class App 
{
    public static void main( String[] args )
    {
        Estacion estacion = new Estacion();

        for (int i = 0; i < 5; i++) {
            Clientes cliente = new Clientes(estacion, i);
            cliente.start();
        }

        for (int i = 0; i < 2; i++) {
            Empleados empleado = new Empleados(estacion, i);
            empleado.start();
        }
    }
}
