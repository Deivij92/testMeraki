package com.test.merakibbva.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(nullable = false, unique = true)  // Asegura unicidad
    private Long identificador;

    // Constructor, getters y setters

    public Usuario() {}

    public Usuario(String nombre, Long identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " (ID: " + id + ")";
    }
}
