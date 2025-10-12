package com.example;


public class App 
{
    public static void main( String[] args )
    {
        Coches coche1 = new Coches("Coche 1", 100);
        Coches coche2 = new Coches("Coche 2", 100);
        Coches coche3 = new Coches("Coche 3", 100);

        coche1.start();
        coche2.start();
        coche3.start();
    }
}
