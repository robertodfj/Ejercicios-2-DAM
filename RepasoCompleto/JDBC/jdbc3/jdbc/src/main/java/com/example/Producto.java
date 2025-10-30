package com.example;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int categoriaId;
    private int stock;

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(String nombre, String descripcion, int categoriaId, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
        this.stock = stock;
    }

    // Constructor completo
    public Producto(int id, String nombre, String descripcion, int categoriaId, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + descripcion + " | Cat: " + categoriaId + " | Stock: " + stock;
    }
}
