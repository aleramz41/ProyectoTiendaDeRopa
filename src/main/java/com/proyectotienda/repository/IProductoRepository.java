/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moduloproducto.Repository;

import com.mycompany.moduloproducto.Model.Producto;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface IProductoRepository {
    void save (Producto producto);
    
    List<Producto> getAllProductos();
}
