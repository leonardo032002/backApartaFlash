package com.example.backendApart.controller;

import com.example.backendApart.entity.Cliente;
import com.example.backendApart.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<Boolean> guardarCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> traerClientePorId(@PathVariable Long id) {
        Cliente clienteId = clienteService.traerClientePorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(clienteId);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> traerClientes() {
        List<Cliente> listaCliente = clienteService.traerClientes();
        return ResponseEntity.status(HttpStatus.OK).body(listaCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.actualizarCliente(id, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
