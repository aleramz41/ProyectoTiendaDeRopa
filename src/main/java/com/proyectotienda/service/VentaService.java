/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.service;

import com.proyectotienda.model.Ventas;
import com.proyectotienda.model.VentaDetalle;
import com.proyectotienda.model.Cliente;

import com.proyectotienda.model.Producto;
import com.proyectotienda.repository.IVentaRepository;
import com.proyectotienda.repository.VentaRepository;
//import com.proyectotienda.service.IVentaService;
//import com.proyectotienda.service.IClienteService;
//import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class VentaService implements IVentaService {
    private final IVentaRepository ventaRepository;
    private final ICalculadorTotal calculadorTotal;
    private final IProductoService productoService;

    private final IClienteService clienteService;
    
    private int contadorDetalle = 1;
    private int contadorVenta = 1;

    public VentaService(VentaRepository ventaRepository, CalculadorTotalVenta calculadorTotal, IProductoService productoService, IClienteService clienteService) {
        this.ventaRepository = ventaRepository;
        this.calculadorTotal = calculadorTotal;
        this.productoService = productoService;
        this.clienteService = clienteService;
    }

    public void registrarVenta(int idCliente, ArrayList<VentaDetalle> detalles) {
        Cliente cliente = clienteService.buscarClientePorId(idCliente);

        if(cliente == null){
            throw new IllegalArgumentException(
                "Cliente no encontrado"
            );
        }

        if(detalles == null || detalles.isEmpty()){
            throw new IllegalArgumentException(
                "La venta no tiene productos"
            );

        }

        double total = calculadorTotal.calcularTotal(detalles);

        int idVenta = contadorVenta++;
        
        // Asignar idVenta a todos los detalles
        for (VentaDetalle detalle : detalles) {
            detalle.setIdVenta(idVenta);
        }

        Ventas venta = new Ventas(
            idVenta,
            cliente,
            detalles,
            total,
            java.time.LocalDate.now().toString()
        );
        
        for (VentaDetalle detalle : detalles) {
            productoService.descontarStock(detalle.getProducto().getCodigo(),detalle.getCantidad());
        }

        ventaRepository.save(venta);
    }

    public List<Ventas> getAllVentas() {
        return ventaRepository.getAllVentas();
    }

    public double calcularTotal(ArrayList<VentaDetalle> detalles) {
        return calculadorTotal.calcularTotal(detalles);
    }


    public VentaDetalle crearDetalleVenta(List<VentaDetalle> detalles, int codigoProducto, int cantidad) {

        Producto producto = productoService.getProductoByCodigo(codigoProducto);

        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }

        VentaDetalle existente = detalles.stream().filter(d -> d.getProducto().getCodigo() == codigoProducto).findFirst().orElse(null);

        if (existente != null) {
            int nuevaCantidad = existente.getCantidad() + cantidad;

            if (nuevaCantidad > producto.getStock()) {

                throw new IllegalArgumentException("Stock insuficiente.");
            }

            existente.setCantidad(nuevaCantidad);
            return existente;
        }

        if (cantidad > producto.getStock()) {
            throw new IllegalArgumentException("Stock insuficiente.");
        }

        VentaDetalle detalle = new VentaDetalle(contadorDetalle++, 0, producto.getCodigo(), producto, cantidad, producto.getPrecio());
        detalles.add(detalle);

        return detalle;

    }
}

