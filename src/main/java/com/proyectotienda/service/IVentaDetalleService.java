package com.proyectotienda.service;

import com.proyectotienda.model.VentaDetalle;
import java.util.List;

/**
 * Interfaz para el servicio de detalles de venta.
 */
public interface IVentaDetalleService {
    void registrarDetalle(int id, int idVenta, com.proyectotienda.model.Producto producto, int cantidad, double precioUnitario);
    List<VentaDetalle> getAllDetalles();
    VentaDetalle getDetalleById(int id);
}