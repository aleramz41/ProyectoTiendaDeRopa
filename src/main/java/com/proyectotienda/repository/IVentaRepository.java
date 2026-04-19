/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.Ventas;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IVentaRepository {
    
    void save(Ventas venta);
    List<Ventas> getAllVentas();

}
