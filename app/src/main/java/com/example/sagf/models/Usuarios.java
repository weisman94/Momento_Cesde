package com.example.sagf.models;

import java.io.Serializable;

public class Usuarios implements Serializable {

    private String id;
    private String nit_cedula;
    private String nombre;
    private String Clave;
    private String tipousuario;

    @Override
    public String toString() {
        return "Usuarios{" +
                "id='" + id + '\'' +
                ", nit_cedula='" + nit_cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Clave='" + Clave + '\'' +
                ", tipousuario='" + tipousuario + '\'' +
                '}';
    }

    public Usuarios() {
    }

    public Usuarios(String id, String nit_cedula, String nombre, String clave, String tipousuario) {
        this.id = id;
        this.nit_cedula = nit_cedula;
        this.nombre = nombre;
        Clave = clave;
        this.tipousuario = tipousuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNit_cedula() {
        return nit_cedula;
    }

    public void setNit_cedula(String nit_cedula) {
        this.nit_cedula = nit_cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
}
