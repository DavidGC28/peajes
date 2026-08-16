package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ValidadorUtil;

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




    public Vehiculo registrarVehiculo(String placa, String tipo, Conductor conductor, String idTag) {
        if (!ValidadorUtil.esTipoValido(tipo)) {
            System.out.println("Error: Tipo de vehículo inválido ('" + tipo + "'). Debe ser 'L' o 'P'.");
            return null;
        }

        Vehiculo vehiculo = new Vehiculo(placa);
        vehiculo.setTipo(tipo.toUpperCase());
        vehiculo.setPropietario(conductor);

        TagElectronico tag = new TagElectronico(idTag);
        vehiculo.setTag(tag);

        return vehiculo;
    }


    public boolean recargarTag(TagElectronico tag, double monto) {
        if (tag == null) {
            System.out.println("Error: El tag no existe.");
            return false;
        }

        if (!ValidadorUtil.esMontoValido(monto)) {
            System.out.println("Error: El monto de recarga debe ser mayor a cero.");
            return false;
        }

        tag.setSaldo(tag.getSaldo() + monto);
        return true;
    }

  
    public boolean cobrarPeaje(Vehiculo vehiculo) {
        if (vehiculo == null || vehiculo.getTag() == null) {
            System.out.println("Error: Vehículo o tag no válidos para el cobro.");
            return false;
        }

     
        double tarifaActual = 0.0;
        if (vehiculo.getTipo().equalsIgnoreCase("L")) {
            tarifaActual = tarifaLiviano;
        } else if (vehiculo.getTipo().equalsIgnoreCase("P")) {
            tarifaActual = tarifaPesado;
        } else {
            System.out.println("Error: Tipo de vehículo desconocido.");
            return false;
        }

        
        TagElectronico tag = vehiculo.getTag();
        if (!tag.isActivo()) {
            System.out.println("Error: El tag se encuentra inactivo.");
            return false;
        }

        if (tag.getSaldo() < tarifaActual) {
            System.out.println("Saldo insuficiente en el tag. Tarifa requerida: $" + tarifaActual + ", Saldo actual: $" + tag.getSaldo());
            return false;
        }

       
        tag.setSaldo(tag.getSaldo() - tarifaActual);
        System.out.println("¡Cobro exitoso! Se descontó $" + tarifaActual + " del tag " + tag.getIdTag());
        return true;
    }


    public boolean transferirSaldoTag(TagElectronico origen, TagElectronico destino, double monto) {
        if (origen == null || destino == null) {
            System.out.println("Error: Tag de origen o destino inválidos.");
            return false;
        }

        if (!ValidadorUtil.esMontoValido(monto)) {
            System.out.println("Error: El monto a transferir debe ser mayor a cero.");
            return false;
        }

     
        if (origen.getSaldo() < monto) {
            System.out.println("Error: Saldo insuficiente en el tag de origen para realizar la transferencia.");
            return false;
        }

 
        origen.setSaldo(origen.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);
        System.out.println("Transferencia exitosa de $" + monto + " del tag " + origen.getIdTag() + " al tag " + destino.getIdTag());
        return true;
    }
}