/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.service;

import com.proyectotienda.model.Ventas;
import com.proyectotienda.model.VentaDetalle;
import com.proyectotienda.model.Cliente;
import com.proyectotienda.repository.IVentaRepository;
import com.proyectotienda.repository.VentaRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class VentaService {
    private final IVentaRepository ventaRepository;
    private final ICalculadorTotal calculadorTotal;

    public VentaService(VentaRepository ventaRepository, CalculadorTotalVenta calculadorTotal) {
        this.ventaRepository = ventaRepository;
        this.calculadorTotal = calculadorTotal;
    }

    public void registrarVenta(String id, Cliente cliente, ArrayList<VentaDetalle> detalles, String fecha) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la venta es obligatorio.");
        }

        if (cliente == null) {
            throw new IllegalArgumentException("El cliente es obligatorio.");
        }

        if (detalles == null || detalles.isEmpty()) {
            throw new IllegalArgumentException("La venta debe contener al menos un producto.");
        }

        double total = calculadorTotal.calcularTotal(detalles);

        Ventas venta = new Ventas(id, cliente, detalles, total, fecha);
        ventaRepository.save(venta);
    }

    public List<Ventas> getAllVentas() {
        return ventaRepository.getAllVentas();
    }

    public double calcularTotal(ArrayList<VentaDetalle> detalles) {
        return calculadorTotal.calcularTotal(detalles);
    }
}

