/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.service;

import com.proyectotienda.model.VentaDetalle;
import com.proyectotienda.model.Producto;
import com.proyectotienda.repository.IVentaDetalleRepository;
import com.proyectotienda.repository.VentaDetalleRepository;

//import com.proyectotienda.service.IVentaDetalleService;
import java.util.List;

/**
 *
 * @author aleja
 */
public class VentaDetalleService implements IVentaDetalleService {
    private final IVentaDetalleRepository ventaDetalleRepository;


    public VentaDetalleService(VentaDetalleRepository ventaDetalleRepository) {
        this.ventaDetalleRepository = ventaDetalleRepository;

    }


    public VentaDetalle crearDetalleValidado(Producto producto, int cantidad, double precioUnitario) {
 
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio.");
        }

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }

        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo.");
        }

        return new VentaDetalle(producto.getCodigo(), producto, cantidad, precioUnitario);
    }

    public void registrarDetalle(int ventaId,Producto producto,int cantidad,double precioUnitario) {
        ventaDetalleRepository.save(ventaId,producto,cantidad,precioUnitario);
    }

    public List<VentaDetalle> getAllDetalles() {
        return ventaDetalleRepository.getAllDetalles();
    }


    public VentaDetalle getDetalleById(int id) {
        return ventaDetalleRepository.getDetalleById(id);
    }

    public void eliminarDetalle(int id) {

        ventaDetalleRepository.delete(id);
    }

    public double calcularSubtotal(int cantidad, double precioUnitario) {
        return cantidad * precioUnitario;
    }
}
