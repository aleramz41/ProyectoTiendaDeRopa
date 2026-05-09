/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.repository;

//import com.proyectotienda.model.Cliente;
import com.proyectotienda.model.VentaDetalle;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aleja
 */
public class VentaDetalleRepository implements IVentaDetalleRepository {

    
    @Override
    public void save(VentaDetalle detalle) {
        String sql = "INSERT INTO venta_detalle (id_venta, id_producto, cantidad, precio) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdVenta());
            stmt.setInt(2, detalle.getIdProducto());
            stmt.setInt(3, detalle.getCantidad());
            stmt.setDouble(4, detalle.getPrecioUnitario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<VentaDetalle> getAllDetalles() {
        List<VentaDetalle> detalles = new ArrayList<>();
        String sql = "SELECT * FROM venta_detalle";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                VentaDetalle detalle = new VentaDetalle();
                detalle.setId(rs.getInt("id"));
                detalle.setIdVenta(rs.getInt("id_venta"));
                detalle.setIdProducto(rs.getInt("id_producto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioUnitario(rs.getDouble("precio"));
                detalles.add(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }
    
    
    @Override

    public VentaDetalle getDetalleById(int id) {
        VentaDetalle detalle = null;
        String sql = "SELECT * FROM venta_detalle WHERE id = ?";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    detalle = new VentaDetalle();
                    detalle.setId(rs.getInt("id"));
                    detalle.setIdVenta(rs.getInt("id_venta"));
                    detalle.setIdProducto(rs.getInt("id_producto"));
                    detalle.setCantidad(rs.getInt("cantidad"));
                    detalle.setPrecioUnitario(rs.getDouble("precio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalle;
    }
    
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM venta_detalle WHERE id = ?";
        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}   
