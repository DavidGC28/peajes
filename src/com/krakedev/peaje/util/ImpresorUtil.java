package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ImpresorUtil {

  
    public static void imprimirVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            System.out.println("El vehículo es nulo.");
            return;
        }

      
        System.out.println("-------------DETALLE COMPLETO VEHÍCULO------------");
        
        
      
        vehiculo.imprimir();
        
      
        if (vehiculo.getPropietario() != null) {
            System.out.print("Propietario -> ");
            vehiculo.getPropietario().imprimir();
        } else {
            System.out.println("Propietario -> No asignado");
        }
        
    
        if (vehiculo.getTag() != null) {
            System.out.print("Tag -> ");
            vehiculo.getTag().imprimir();
            System.out.println("Saldo disponible: $" + vehiculo.getTag().getSaldo());
        } else {
            System.out.println("Tag -> No asignado");
        }
        
        System.out.println("--------------------------------------------------------");
    }
}