/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.service;

import com.proyectotienda.model.Ventas;
import com.proyectotienda.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author aleja
 */
public class ReporteService {
    private final IVentaRepository ventaRepository;

    public ReporteService(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public void generarVentaDelDia(LocalDate fecha) {
        List<Ventas> ventasDelDia = ventaRepository.getAllVentas().stream()
                                                     .filter(v -> v.getFecha().equals(fecha.toString()))
                                                     .toList();
        System.out.println("===== REPORTE DE VENTAS DEL " + fecha + " =====");
        for (Ventas venta : ventasDelDia) {
            System.out.println(venta);
        }
    }

    public double calcularTotalVentasDelDia(LocalDate fecha) {
        return ventaRepository.getAllVentas().stream()
                              .filter(v -> v.getFecha().equals(fecha.toString()))
                              .mapToDouble(Ventas::getTotal)
                              .sum();
    }

    public int contarVentasDelDia(LocalDate fecha) {
        return (int) ventaRepository.getAllVentas().stream()
                                    .filter(v -> v.getFecha().equals(fecha.toString()))
                                    .count();
    }
}
