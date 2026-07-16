package com.elviejomolino.gestorarticulos.model;

// IMPORTO LOCALDATE;
import java.time.LocalDate;

// IMPORTO OBJECTS;
import java.util.Objects;

public class Articulo { // INICIO CLASE ARTICULO;

    // ESTADO: ATRIBUTOS;
    private Long id;
    private String nombre;
    private LocalDate fechaCreacion;
    private double precio;
    private String descripcion;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public Articulo() {

    }

    // CONSTRUCTOR PARAMETRIZADO;
    public Articulo(
            String nombre,
            LocalDate fechaCreacion,
            double precio,
            String descripcion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Articulo(
            Long id,
            String nombre,
            LocalDate fechaCreacion,
            double precio,
            String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // GETTERS Y SETTERS;
    // ID;
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // NOMBRE;
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // FECHACREACION;
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // PRECIO;
    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // DESCRIPCION;
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // EQUALS();
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Articulo articulo = (Articulo) obj;

        return Objects.equals(this.id, articulo.getId());

    }

    // HASHCODE();
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TOSTRING();
    @Override
    public String toString() {
        return "Articulo[id= " + id
                + ", nombre= " + nombre
                + ", fecha de creación= " + fechaCreacion
                + ", precio= " + precio
                + ", descripción= " + descripcion + "]";
    }

} // FINAL CLASE ARTICULO;
