package com.hojo.fenix.navidad.entity;

import javax.validation.constraints.NotEmpty;

public class JugarRequest {

    @NotEmpty
    private String nombre;

    private String asignado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getAsignado() {
        return asignado;
    }

    public void setAsignado(String asignado) {
        this.asignado = asignado;
    }
}
