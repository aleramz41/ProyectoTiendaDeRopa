/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.Cliente;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IClienteRepository {
        
    void save (Cliente cliente);
    List<Cliente> getAllClients();
    void actualizarCliente(Cliente cliente);
}
