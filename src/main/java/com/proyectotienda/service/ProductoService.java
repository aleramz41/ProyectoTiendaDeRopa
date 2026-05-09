/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.service;

import com.proyectotienda.model.Producto;
import com.proyectotienda.repository.IProductoRepository;
//import com.proyectotienda.repository.ProductoRepository;
//import com.proyectotienda.service.IProductoService;
import java.util.List;

/**
 *
 * @author aleja
 */
public class ProductoService implements IProductoService {
    private final IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    public void registrarProducto(String nombre, String talla, String color, double precio, int stock) {
        
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        Producto producto = new Producto(nombre, talla, color, precio, stock);
        productoRepository.save(producto);
    }

    public List<Producto> getAllProductos() {
        return productoRepository.getAllProductos();
    }


    public Producto getProductoByCodigo(int codigo) {
        return productoRepository.getProductoByCodigo(codigo);
    }

    public void actualizarProducto(int codigo, String nombre, String talla, String color, double precio, int stock) {

        Producto producto = getProductoByCodigo(codigo);
        if (producto == null) {
            throw new IllegalArgumentException("Producto con código " + codigo + " no encontrado.");
        }

        producto.setNombre(nombre);
        producto.setTalla(talla);
        producto.setColor(color);
        producto.setPrecio(precio);
        producto.setStock(stock);
    }


    public void eliminarProducto(int codigo) {
        productoRepository.eliminarProducto(codigo);
    }

    public void descontarStock(int codigo, int cantidad) {

        Producto producto = getProductoByCodigo(codigo);
        if (producto == null) {
            throw new IllegalArgumentException("Producto con código " + codigo + " no encontrado.");
        }
        
        if (producto.getStock() < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente para el producto: " + producto.getNombre());
        }
        
        producto.setStock(producto.getStock() - cantidad);
    }
}
