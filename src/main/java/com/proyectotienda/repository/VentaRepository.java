/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.Cliente;
import com.proyectotienda.model.Ventas;
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
public class VentaRepository implements IVentaRepository {
    
    private final IClienteRepository clienteRepository;
    
    public VentaRepository(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public int save(Ventas venta) {
        String sql = "INSERT INTO ventas (cliente_id, total, fecha) VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = DatabaseConnection.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venta.getCliente().getId());
            stmt.setDouble(2, venta.getTotal());
            stmt.setString(3, venta.getFecha());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    @Override
    public List<Ventas> getAllVentas() {
        List<Ventas> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";

        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ventas venta = new Ventas();
                
                Cliente cliente = clienteRepository.buscarClientePorId(rs.getInt("cliente_id"));
                venta.setCliente(cliente);

                venta.setId(rs.getInt("id"));
                venta.setTotal(rs.getDouble("total"));
                venta.setFecha(rs.getString("fecha"));

                // Inicializar lista de detalles
                venta.setDetalles(new ArrayList<>());

                ventas.add(venta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }
}
