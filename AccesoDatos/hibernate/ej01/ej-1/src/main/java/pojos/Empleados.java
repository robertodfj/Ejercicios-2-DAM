package pojos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private int id;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private String nombre;
    private String apellido;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "fecha_contratacion")
    private Date fechaContratacion;

    public enum Genero { M, F, O }

    public Empleados() {}

    public Empleados(Date fechaNacimiento, String nombre, String apellido, Genero genero, Date fechaContratacion) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaContratacion = fechaContratacion;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }
    public Date getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    @Override
    public String toString() {
        return "Empleado [id=" + id 
                + ", nombre=" + nombre 
                + ", apellido=" + apellido 
                + ", genero=" + genero 
                + ", fechaNacimiento=" + fechaNacimiento 
                + ", fechaContratacion=" + fechaContratacion 
                + "]";
    }
}