package com.example;

public class Main {
    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // INSERTAR
        Producto nuevo = new Producto("Teclado mecánico", "Switches azules", 2, 15);
        dao.insertar(nuevo);

        // MOSTRAR TODOS
        System.out.println("Lista de productos:");
        dao.mostrar();
        

        // ELIMINAR
        dao.eliminar(5); // cambia el ID por uno existente
    }
}