/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.Producto;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Windows
 */
public class ProductoRepository implements IProductoRepository{

    
    
    @Override
    public void save(Producto producto) {
        String sql = "INSERT INTO Productos (codigo, nombre, talla, color, precio, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getTalla());
            stmt.setString(4, producto.getColor());
            stmt.setDouble(5, producto.getPrecio());
            stmt.setInt(6, producto.getStock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> getAllProductos() {

        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setTalla(rs.getString("talla"));
                producto.setColor(rs.getString("color"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE Productos SET nombre = ?, talla = ?, color = ?, precio = ?, stock = ? WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getTalla());
            stmt.setString(3, producto.getColor());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setInt(6, producto.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(int codigo) {
        String sql = "DELETE FROM Productos WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Producto getProductoByCodigo(int codigo) {

        String sql = "SELECT * FROM Productos WHERE codigo = ?";
    try (Connection conn = DatabaseConnection.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, codigo);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Producto(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("talla"),
                    rs.getString("color"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;

    }
} 
