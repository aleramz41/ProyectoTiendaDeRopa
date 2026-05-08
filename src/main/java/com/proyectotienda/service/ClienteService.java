
    package com.proyectotienda.service;

import java.util.List;

import com.proyectotienda.model.Cliente;
import com.proyectotienda.repository.IClienteRepository;
import com.proyectotienda.service.IClienteService;

/**
 *
 * @author aleja
 */
public class ClienteService implements IClienteService {
        private final IClienteRepository clienteRepository;

        public ClienteService(IClienteRepository clienteRepository) {
            this.clienteRepository = clienteRepository;
        }

        public void registrarCliente(int id, String name, String email, String telefono) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio.");
            }

            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("El correo es obligatorio.");
            }

            Cliente client = new Cliente(id, name, email, telefono);
            clienteRepository.save(client);
        }

        public void actualizarCliente(int id, String nombre, String email, String telefono) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio.");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("El correo es obligatorio.");
            }
            Cliente cliente = new Cliente(id, nombre, email, telefono);
            clienteRepository.actualizarCliente(cliente);
        }
        public void eliminarCliente(int id) {
            clienteRepository.eliminarCliente(id);
        }
        public List<Cliente> getAllClients() {
            return clienteRepository.getAllClients();
        }
    }
