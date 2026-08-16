package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ImpresorUtil;

public class TestVehiculo {
    public static void main(String[] args) {
     
        Conductor conductor1 = new Conductor("1712345678", "Carlos", "Pérez");

       
        Vehiculo vehiculo1 = new Vehiculo("PBC-1234");
        vehiculo1.setTipo("L");

       
        TagElectronico tag1 = new TagElectronico("TAG-9988");

       
        vehiculo1.setPropietario(conductor1);
        vehiculo1.setTag(tag1);

     
        System.out.println("--- Impresión del Vehículo---");
        vehiculo1.imprimir();

        System.out.println("\n--- Impresión completa ---");
        ImpresorUtil.imprimirVehiculo(vehiculo1);
    }
}