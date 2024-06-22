/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backendApart.controller;


import com.example.backendApart.entity.Mantenimiento;
import com.example.backendApart.service.MantenimientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {
    
    @Autowired
    private MantenimientoService ms;
    
    @PostMapping("/")
    public ResponseEntity<Boolean> guardarCliente(@RequestBody Mantenimiento mantenimiento) {
        ms.crearMantenimiento(mantenimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mantenimiento> traerClientePorId(@PathVariable Long id) {
        Mantenimiento mantenimientoId = ms.traerMantenimientoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(mantenimientoId);
    }

    @GetMapping("/")
    public ResponseEntity<List<Mantenimiento>> traerClientes() {
        List<Mantenimiento> listaMantenimiento = ms.obtenerTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listaMantenimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mantenimiento> actualizarCliente(@PathVariable Long id, @RequestBody Mantenimiento mantenimiento) {
        ms.actualizarCliente(id, mantenimiento);
        return ResponseEntity.status(HttpStatus.OK).body(mantenimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarCliente(@PathVariable Long id) {
        ms.eliminarMantenimiento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
