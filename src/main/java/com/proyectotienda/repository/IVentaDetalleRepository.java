/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.VentaDetalle;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IVentaDetalleRepository {
    
    void save(VentaDetalle ventaDetalle);
    List<VentaDetalle> getAllDetalles();

    VentaDetalle getDetalleById(int id);
    void delete(int id);

}
