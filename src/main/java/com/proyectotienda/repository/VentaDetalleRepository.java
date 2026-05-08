/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.VentaDetalle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class VentaDetalleRepository implements IVentaDetalleRepository {
    private final List<VentaDetalle> detalles;
    
    public VentaDetalleRepository() {
        this.detalles = new ArrayList<>();
    }
    
    @Override
    public void save(VentaDetalle ventaDetalle) {
        detalles.add(ventaDetalle);
    }
    
    @Override
    public List<VentaDetalle> getAllDetalles() {
        return new ArrayList<>(detalles);
    }
    
    @Override
    public VentaDetalle getDetalleById(int id) {
        return detalles.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }
    
    @Override
    public void delete(int id) {
        detalles.removeIf(d -> d.getId() == id);
    }
}
