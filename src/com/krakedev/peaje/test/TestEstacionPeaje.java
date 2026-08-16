package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.servicios.EstacionPeaje;
import com.krakedev.peaje.util.ImpresorUtil;

public class TestEstacionPeaje {
    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBAS DEL SISTEMA DE PEAJE ===\n");

        
        EstacionPeaje estacion = new EstacionPeaje();
        Conductor conductor1 = new Conductor("1728394050", "María", "Gómez");

       
        System.out.println("--- PRUEBA 1: Registro de Vehículo ---");
        Vehiculo vehiculo1 = estacion.registrarVehiculo("ABC-123", "L", conductor1, "TAG-001");
        
        
        System.out.println("\n--- PRUEBA 2: Impresión Detallada con ImpresorUtil ---");
        ImpresorUtil.imprimirVehiculo(vehiculo1);

       
        System.out.println("\n--- PRUEBA 3: Recarga de Tag ---");
        estacion.recargarTag(vehiculo1.getTag(), 5.00);
        System.out.println("Saldo después de recarga: $" + vehiculo1.getTag().getSaldo());

        
        System.out.println("\n--- PRUEBA 4: Cobro de Peaje (Vehículo Liviano) ---");
        estacion.cobrarPeaje(vehiculo1);
        System.out.println("Saldo restante en el tag: $" + vehiculo1.getTag().getSaldo());

   
        System.out.println("\n--- PRUEBA 5: Transferencia de Saldo entre Tags ---");
        TagElectronico tagDestino = new TagElectronico("TAG-002");
        
        System.out.println("Saldo inicial Tag Destino (" + tagDestino.getIdTag() + "): $" + tagDestino.getSaldo());
        estacion.transferirSaldoTag(vehiculo1.getTag(), tagDestino, 2.00);
        
        System.out.println("Saldo final Tag Origen (" + vehiculo1.getTag().getIdTag() + "): $" + vehiculo1.getTag().getSaldo());
        System.out.println("Saldo final Tag Destino (" + tagDestino.getIdTag() + "): $" + tagDestino.getSaldo());

        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}