/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows
 */
public class ProductoRepository implements IProductoRepository{
    private final List<Producto> productos;
    
    public ProductoRepository(){
        this.productos = new ArrayList<>();
    }
    
    @Override
    public void save(Producto producto) {
        productos.add(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return new ArrayList<>(productos);
    }

    @Override
    public Producto getProductoByCodigo(int codigo) {
        return productos.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
    }

    @Override
    public void deleteByCodigo(int codigo) {
        productos.removeIf(p -> p.getCodigo() == codigo);
    }
} 
