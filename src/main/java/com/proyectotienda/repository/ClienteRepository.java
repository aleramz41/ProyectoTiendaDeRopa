/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectotienda.repository;

import com.proyectotienda.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class ClienteRepository implements IClienteRepository{
    private final List<Cliente> clients;
    
    public ClienteRepository() {
        this.clients = new ArrayList<>();
    }
    
    @Override
    public void save(Cliente cliente) {
        clients.add(cliente);
    }

    @Override
    public List<Cliente> getAllClients() {
        return new ArrayList<>(clients);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == cliente.getId()) {
                clients.set(i, cliente);
                return;
            }
        }
    }
}
