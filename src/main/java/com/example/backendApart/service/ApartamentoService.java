package com.example.backendApart.service;

import com.example.backendApart.entity.Apartamento;
import com.example.backendApart.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public void crearApartamento(Apartamento apartamento) {
        apartamentoRepository.save(apartamento);
    }

    public Apartamento traerApartamentoPorId(Long id) {
        Optional<Apartamento> apartamentoId = apartamentoRepository.findById(id);
        if (apartamentoId.isPresent()) {
            return apartamentoRepository.getReferenceById(id);
        }
        throw new RuntimeException("No existe el id");
    }

    public List<Apartamento> traerApartamentos() {
        return apartamentoRepository.findAll();
    }

    public Apartamento actualizarApartamento(Long id, Apartamento apartamento) {
        Optional<Apartamento> apartamentoId = apartamentoRepository.findById(id);
        if (apartamentoId.isPresent()) {
            Apartamento apartamentoActualizar = apartamentoId.get();

            apartamentoActualizar.setNombre(apartamento.getNombre());
            apartamentoActualizar.setDescripcion(apartamento.getDescripcion());
            return apartamentoRepository.save(apartamentoActualizar);
        }
        throw new RuntimeException("No existe el id");
    }

    public void eliminarApartamento(Long id) {
        Optional<Apartamento> apartamentoId = apartamentoRepository.findById(id);
        if (apartamentoId.isPresent()) {
            apartamentoRepository.deleteById(id);
        }
        throw new RuntimeException("No existe el id");
    }
}
