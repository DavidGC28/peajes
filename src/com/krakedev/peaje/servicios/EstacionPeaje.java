package com.krakedev.peaje.servicios;

public class EstacionPeaje {
    private int codigoEstacion = 500;
    private double tarifaLiviano = 1.00;
    private double tarifaPesado = 2.50;

    
    public EstacionPeaje() {
    }

  
    public int getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(int codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }

    public double getTarifaLiviano() {
        return tarifaLiviano;
    }

    public void setTarifaLiviano(double tarifaLiviano) {
        this.tarifaLiviano = tarifaLiviano;
    }

    public double getTarifaPesado() {
        return tarifaPesado;
    }

    public void setTarifaPesado(double tarifaPesado) {
        this.tarifaPesado = tarifaPesado;
    }
}