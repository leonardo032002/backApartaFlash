package com.example.backendApart.controller;

import com.example.backendApart.entity.Apartamento;
import com.example.backendApart.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @PostMapping("/")
    public ResponseEntity<Boolean> crearApartamento(@RequestBody Apartamento apartamento) {
        apartamentoService.crearApartamento(apartamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartamento> traerApartamentoPorId(@PathVariable Long id) {
        Apartamento apartamentoId = apartamentoService.traerApartamentoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(apartamentoId);
    }

    @GetMapping("/")
    public ResponseEntity<List<Apartamento>> traerApartamentos() {
        List<Apartamento> apartamentos = apartamentoService.traerApartamentos();
        return ResponseEntity.status(HttpStatus.OK).body(apartamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartamento> actualizarApartamento(@PathVariable Long id, @RequestBody Apartamento apartamento) {
        apartamentoService.actualizarApartamento(id, apartamento);
        return ResponseEntity.status(HttpStatus.OK).body(apartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarApartamento(@PathVariable Long id) {
        apartamentoService.eliminarApartamento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
