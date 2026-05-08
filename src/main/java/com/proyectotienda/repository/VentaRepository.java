/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.Ventas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class VentaRepository implements IVentaRepository {
    private final List<Ventas> ventas;
    
    public VentaRepository() {
        this.ventas = new ArrayList<>();
    }
    
    @Override
    public void save(Ventas venta) {
        ventas.add(venta);
    }
    
    @Override
    public List<Ventas> getAllVentas() {
        return new ArrayList<>(ventas);
    }
    
}
