package com.example;

public class App 
{
    public static void main( String[] args )
    {
        Cafeteria cafeteria = new Cafeteria();

        Camarero camarero1 = new Camarero(1, cafeteria);
        Camarero camarero2 = new Camarero(2, cafeteria);
        Camarero camarero3 = new Camarero(3, cafeteria);

        Estudiantes estudiante1 = new Estudiantes(1, cafeteria);
        Estudiantes estudiante2 = new Estudiantes(2, cafeteria);
        Estudiantes estudiante3 = new Estudiantes(3, cafeteria);
        Estudiantes estudiante4 = new Estudiantes(4, cafeteria);
        Estudiantes estudiante5 = new Estudiantes(5, cafeteria);
        Estudiantes estudiante6 = new Estudiantes(6, cafeteria);
        Estudiantes estudiante7 = new Estudiantes(7, cafeteria);
        Estudiantes estudiante8 = new Estudiantes(8, cafeteria);
        Estudiantes estudiante9 = new Estudiantes(9, cafeteria);
        Estudiantes estudiante10 = new Estudiantes(10, cafeteria);

        camarero1.start();
        camarero2.start();
        camarero3.start();

        estudiante1.start();
        estudiante2.start();
        estudiante3.start();
        estudiante4.start();
        estudiante5.start();
        estudiante6.start();
        estudiante7.start();
        estudiante8.start();
        estudiante9.start();
        estudiante10.start();
    }
}
