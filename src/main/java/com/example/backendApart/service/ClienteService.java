package com.example.backendApart.service;

import com.example.backendApart.entity.Cliente;
import com.example.backendApart.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        Optional<Cliente> clienteId = clienteRepository.findById(id);
        if (clienteId.isPresent()) {
            clienteRepository.deleteById(id);
        }
        throw new RuntimeException("No existe el id");
    }
}
