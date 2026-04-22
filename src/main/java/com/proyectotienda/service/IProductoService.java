package com.proyectotienda.service;

import com.proyectotienda.model.Producto;
import java.util.List;

/**
 * Interfaz para el servicio de productos.
 */
public interface IProductoService {
    void registrarProducto(String codigo, String nombre, String talla, String color, double precio, int stock);
    List<Producto> getAllProductos();
    Producto getProductoByCodigo(String codigo);
    void actualizarProducto(String codigo, String nombre, String talla, String color, double precio, int stock);
    void eliminarProducto(String codigo);
    void descontarStock(String codigo, int cantidad);
}