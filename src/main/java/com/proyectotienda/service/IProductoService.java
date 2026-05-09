package com.proyectotienda.service;

import com.proyectotienda.model.Producto;
import java.util.List;

/**
 * Interfaz para el servicio de productos.
 */
public interface IProductoService {

    void registrarProducto(String nombre, String talla, String color, double precio, int stock);
    List<Producto> getAllProductos();
    Producto getProductoByCodigo(int codigo);
    void actualizarProducto(int codigo, String nombre, String talla, String color, double precio, int stock);
    void eliminarProducto(int codigo);
    void descontarStock(int codigo, int cantidad);

}