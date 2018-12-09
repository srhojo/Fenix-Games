package com.hojo.fenix.navidad.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "PLAYERS")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;
    private String asigandoA;
    private Boolean juegado = Boolean.FALSE;
    private LocalDateTime fechaJugado;

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

    public String getAsigandoA() {
        return asigandoA;
    }

    public void setAsigandoA(String asigandoA) {
        this.asigandoA = asigandoA;
    }

    public Boolean getJuegado() {
        return juegado;
    }

    public void setJuegado(Boolean juegado) {
        this.juegado = juegado;
    }

    public LocalDateTime getFechaJugado() {
        return fechaJugado;
    }

    public void setFechaJugado(LocalDateTime fechaJugado) {
        this.fechaJugado = fechaJugado;
    }
}
