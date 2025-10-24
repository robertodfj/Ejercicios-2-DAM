package com.example;


public class App 
{
    public static void main( String[] args )
    {
        Usuarios usuarios = new Usuarios();

        Fichero f1 = new Fichero(usuarios, false, "Usuario 1");
        Fichero f2 = new Fichero(usuarios, true, "Usuario 2");
        Fichero f3 = new Fichero(usuarios, false, "Usuario 3");

        f1.start();
        f2.start();
        f3.start();
    }


}
