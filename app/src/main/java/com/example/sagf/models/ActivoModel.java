package com.example.sagf.models;

import java.io.Serializable;

public class ActivoModel implements Serializable {

    private String id;
    private String etSerial;
    private String etElemento;
    private String etModelo;
    private String etMarca;
    private String etEmpresa;
    private String etDescripcion;

    @Override
    public String toString() {
        return "ActivoModel{" +
                "id='" + id + '\'' +
                ", etSerial='" + etSerial + '\'' +
                ", etElemento='" + etElemento + '\'' +
                ", etModelo='" + etModelo + '\'' +
                ", etMarca='" + etMarca + '\'' +
                ", etEmpresa='" + etEmpresa + '\'' +
                ", etDescripcion='" + etDescripcion + '\'' +
                '}';
    }

    public ActivoModel() {
    }

    public ActivoModel(String id, String etSerial, String etElemento, String etModelo, String etMarca, String etEmpresa, String etDescripcion) {
        this.id = id;
        this.etSerial = etSerial;
        this.etElemento = etElemento;
        this.etModelo = etModelo;
        this.etMarca = etMarca;
        this.etEmpresa = etEmpresa;
        this.etDescripcion = etDescripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtSerial() {
        return etSerial;
    }

    public void setEtSerial(String etSerial) {
        this.etSerial = etSerial;
    }

    public String getEtElemento() {
        return etElemento;
    }

    public void setEtElemento(String etElemento) {
        this.etElemento = etElemento;
    }

    public String getEtModelo() {
        return etModelo;
    }

    public void setEtModelo(String etModelo) {
        this.etModelo = etModelo;
    }

    public String getEtMarca() {
        return etMarca;
    }

    public void setEtMarca(String etMarca) {
        this.etMarca = etMarca;
    }

    public String getEtEmpresa() {
        return etEmpresa;
    }

    public void setEtEmpresa(String etEmpresa) {
        this.etEmpresa = etEmpresa;
    }

    public String getEtDescripcion() {
        return etDescripcion;
    }

    public void setEtDescripcion(String etDescripcion) {
        this.etDescripcion = etDescripcion;
    }
}
