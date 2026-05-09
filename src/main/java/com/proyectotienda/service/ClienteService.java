

package com.proyectotienda.service;


import java.util.List;

import com.proyectotienda.model.Cliente;
import com.proyectotienda.repository.IClienteRepository;
//import com.proyectotienda.service.IClienteService;

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
            if (id <= 0) {
                throw new IllegalArgumentException("El ID debe ser un número positivo.");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio.");
            }
            
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("El correo es obligatorio.");
            }
            if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                throw new IllegalArgumentException("El formato del correo es inválido.");
            }
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new IllegalArgumentException("El teléfono es obligatorio.");
            }
            if (!telefono.matches("\\d{10}")) {
                throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos.");
            }
            List<Cliente> allClients = clienteRepository.getAllClients();
            for (Cliente c : allClients) {
                if (c.getEmail().equals(email)) {
                    throw new IllegalArgumentException("Ya existe un cliente con este correo.");
                }
            }
            Cliente existing = clienteRepository.buscarClientePorId(id);
            if (existing != null) {
                throw new IllegalArgumentException("Ya existe un cliente con este ID.");
            }
            Cliente client = new Cliente(id, name, email, telefono);
            clienteRepository.save(client);
        }

        public void actualizarCliente(int id, String nombre, String email, String telefono) {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID debe ser un número positivo.");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio.");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("El correo es obligatorio.");
            }
            if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                throw new IllegalArgumentException("El formato del correo es inválido.");
            }
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new IllegalArgumentException("El teléfono es obligatorio.");
            }
            if (!telefono.matches("\\d{10}")) {
                throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos.");
            }
            Cliente existing = clienteRepository.buscarClientePorId(id);
            if (existing == null) {
                throw new IllegalArgumentException("No se encontró un cliente con este ID para actualizar.");
            }
            List<Cliente> allClients = clienteRepository.getAllClients();
            for (Cliente c : allClients) {
                if (c.getId() != id && c.getEmail().equals(email)) {
                    throw new IllegalArgumentException("Ya existe otro cliente con este correo.");
                }
            }
            Cliente cliente = new Cliente(id, nombre, email, telefono);
            clienteRepository.actualizarCliente(cliente);
        }
        public void eliminarCliente(int id) {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID debe ser un número positivo.");
            }
            Cliente existing = clienteRepository.buscarClientePorId(id);
            if (existing == null) {
                throw new IllegalArgumentException("No se encontró un cliente con este ID para eliminar.");
            }
            clienteRepository.eliminarCliente(id);
        }
        public List<Cliente> getAllClients() {
            return clienteRepository.getAllClients();
        }

        
        public Cliente buscarClientePorId(int id) {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID debe ser un número positivo.");
            }
            return clienteRepository.buscarClientePorId(id);
        }

    }
