/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.service;

import com.proyectotienda.model.VentaDetalle;
import java.util.List;

/**
 *
 * @author aleja
 */
public class CalculadorTotalVenta implements ICalculadorTotal {
    
    @Override
    public double calcularTotal(List<?> items) {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }
        
        return items.stream()
                    .filter(item -> item instanceof VentaDetalle)
                    .mapToDouble(item -> ((VentaDetalle) item).getSubtotal())
                    .sum();
    }
}
