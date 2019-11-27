package com.example.sagf.models;

import android.widget.Button;

import java.io.Serializable;

public class FacturaModel implements Serializable {

    private String id;
    private String etIdFactura;
    private String etCliente;
    private String etServicio;
    private String etDescripcionS;


    @Override
    public String toString() {
        return "FacturaModel{" +
                "id='" + id + '\'' +
                ", etIdFactura='" + etIdFactura + '\'' +
                ", etCliente='" + etCliente + '\'' +
                ", etServicio='" + etServicio + '\'' +
                ", etDescripcionS='" + etDescripcionS + '\'' +
                '}';
    }

    public FacturaModel(String id, String etIdFactura, String etCliente, String etServicio, String etDescripcionS) {
        this.id = id;
        this.etIdFactura = etIdFactura;
        this.etCliente = etCliente;
        this.etServicio = etServicio;
        this.etDescripcionS = etDescripcionS;
    }

    public FacturaModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtIdFactura() {
        return etIdFactura;
    }

    public void setEtIdFactura(String etIdFactura) {
        this.etIdFactura = etIdFactura;
    }

    public String getEtCliente() {
        return etCliente;
    }

    public void setEtCliente(String etCliente) {
        this.etCliente = etCliente;
    }

    public String getEtServicio() {
        return etServicio;
    }

    public void setEtServicio(String etServicio) {
        this.etServicio = etServicio;
    }

    public String getEtDescripcionS() {
        return etDescripcionS;
    }

    public void setEtDescripcionS(String etDescripcionS) {
        this.etDescripcionS = etDescripcionS;
    }
}
