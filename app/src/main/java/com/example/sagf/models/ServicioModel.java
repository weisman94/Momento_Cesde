package com.example.sagf.models;

import java.io.Serializable;

public class ServicioModel implements Serializable {

    private String id;
    private String etAservicio;
    private String etIdUser;
    private String etArea;
    private String etTservicio;
    private String etElemento;
    private String etDescrip;


    @Override
    public String toString() {
        return "ServicioModel{" +
                "id='" + id + '\'' +
                ", etAservicio='" + etAservicio + '\'' +
                ", etIdUser='" + etIdUser + '\'' +
                ", etArea='" + etArea + '\'' +
                ", etTservicio='" + etTservicio + '\'' +
                ", etElemento='" + etElemento + '\'' +
                ", etDescrip='" + etDescrip + '\'' +
                '}';
    }

    public ServicioModel() {
    }

    public ServicioModel(String id, String etAservicio, String etIdUser, String etArea, String etTservicio, String etElemento, String etDescrip) {
        this.id = id;
        this.etAservicio = etAservicio;
        this.etIdUser = etIdUser;
        this.etArea = etArea;
        this.etTservicio = etTservicio;
        this.etElemento = etElemento;
        this.etDescrip = etDescrip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtAservicio() {
        return etAservicio;
    }

    public void setEtAservicio(String etAservicio) {
        this.etAservicio = etAservicio;
    }

    public String getEtIdUser() {
        return etIdUser;
    }

    public void setEtIdUser(String etIdUser) {
        this.etIdUser = etIdUser;
    }

    public String getEtArea() {
        return etArea;
    }

    public void setEtArea(String etArea) {
        this.etArea = etArea;
    }

    public String getEtTservicio() {
        return etTservicio;
    }

    public void setEtTservicio(String etTservicio) {
        this.etTservicio = etTservicio;
    }

    public String getEtElemento() {
        return etElemento;
    }

    public void setEtElemento(String etElemento) {
        this.etElemento = etElemento;
    }

    public String getEtDescrip() {
        return etDescrip;
    }

    public void setEtDescrip(String etDescrip) {
        this.etDescrip = etDescrip;
    }
}
