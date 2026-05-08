package com.proyectotienda.service;

import com.proyectotienda.model.VentaDetalle;
import com.proyectotienda.model.Ventas;
import com.proyectotienda.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz para el servicio de ventas.
 */
public interface IVentaService {
    void registrarVenta(String id, Cliente cliente, ArrayList<VentaDetalle> detalles, String fecha);
    List<Ventas> getAllVentas();
    double calcularTotal(ArrayList<VentaDetalle> detalles);
    VentaDetalle crearDetalleVenta(String codigoProducto, int cantidad, String idVenta, int detalleIndex);
}