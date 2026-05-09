package com.proyectotienda.service;

import com.proyectotienda.model.Cliente;
import java.util.List;

/**
 * Interfaz para el servicio de clientes.
 */
public interface IClienteService {
    void registrarCliente(int id, String name, String email, String telefono);
    void actualizarCliente(int id, String nombre, String email, String telefono);
    void eliminarCliente(int id);
    List<Cliente> getAllClients();

    Cliente buscarClientePorId(int id);

}