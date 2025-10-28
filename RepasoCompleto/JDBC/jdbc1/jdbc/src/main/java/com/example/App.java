package com.example;


import java.util.List;

public class App {
    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // INSERTAR
        Producto nuevo = new Producto("Teclado mecánico", "Switches azules", 2, 15);
        dao.insertarProducto(nuevo);

        // MOSTRAR TODOS
        dao.mostrarTodos();

        // ACTUALIZAR
        Producto actualizar = new Producto(1, "Teclado Redragon", "Switches rojos", 2, 20);
        dao.actualizarProducto(actualizar);

        // ELIMINAR
        dao.eliminarProducto(5); // cambia el ID por uno existente
    }
}
