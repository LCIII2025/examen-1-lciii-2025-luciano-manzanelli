package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test

        Estacionamiento estacionamiento = new Estacionamiento();
        Vehiculo vehiculo = new Vehiculo("aa123bb", "corolla", Vehiculo.Tipo.AUTO);
        estacionamiento.ingresarVehiculo("40123123", "Test", vehiculo);

        Ticket ticket = estacionamiento.retirarVehiculo("aa123bb");

        assertEquals("aa123bb", ticket.getVehiculo().getPatente());
        assertTrue(ticket.calcularMinutos() >= 0);
        assertFalse(estacionamiento.listarVehiculosEstacionados().contains(ticket));
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test

        Cliente cliente = new Cliente("40123123", "Test");
        Vehiculo vehiculo = new Vehiculo("aa123bb", "amarok", Vehiculo.Tipo.PICKUP);

        LocalDateTime entrada = LocalDateTime.now();
        LocalDateTime salida = LocalDateTime.now().plusMinutes(61);

        Ticket ticket = new Ticket(cliente, vehiculo, entrada, salida);

        double precio = ticket.calcularPrecio();

        assertEquals(360.0, precio, 0.01);
    }

}