package com.proyectotienda.service;

import com.proyectotienda.model.VentaDetalle;
import java.util.List;

/**
 * Interfaz para el servicio de detalles de venta.
 */
public interface IVentaDetalleService {
    void registrarDetalle(String id, com.proyectotienda.model.Producto producto, int cantidad, double precioUnitario);
    List<VentaDetalle> getAllDetalles();
    VentaDetalle getDetalleById(String id);
}