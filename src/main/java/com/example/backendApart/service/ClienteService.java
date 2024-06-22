package com.example.backendApart.service;

import com.example.backendApart.entity.Cliente;
import com.example.backendApart.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente traerClientePorId(Long id) {
        Optional<Cliente> clienteId = clienteRepository.findById(id);
        if (clienteId.isPresent()) {
            return clienteRepository.getReferenceById(id);
        }
        throw new RuntimeException("No existe el id");
    }

    public List<Cliente> traerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente clienteActualizado = clienteExistente.get();

            clienteActualizado.setNombre(cliente.getNombre());
            clienteActualizado.setApellido(cliente.getApellido());
            clienteActualizado.setCedula(cliente.getCedula());
            return clienteRepository.save(clienteActualizado);
        }
        throw new RuntimeException("No existe el id");
    }

    public void eliminarCliente(Long id) {
        Optional<Cliente> clienteId = clienteRepository.findById(id);
        if (clienteId.isPresent()) {
            clienteRepository.deleteById(id);
        }
        throw new RuntimeException("No existe el id");
    }
}
