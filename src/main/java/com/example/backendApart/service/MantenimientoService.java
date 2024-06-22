package com.example.backendApart.service;



import com.example.backendApart.entity.Mantenimiento;
import com.example.backendApart.repository.MantenimientoReposiory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoReposiory mr;
    
    public List<Mantenimiento> obtenerTodos() {
       return mr.findAll();
    }

    public void crearMantenimiento(Mantenimiento m) {
        mr.save(m);
    }
    
    public Mantenimiento traerMantenimientoPorId(Long id) {
        Optional<Mantenimiento> clienteId = mr.findById(id);
        if (clienteId.isPresent()) {
            return mr.getReferenceById(id);
        }
        throw new RuntimeException("No existe el id");
    }
    
     public Mantenimiento actualizarCliente(Long id, Mantenimiento mantenimiento) {
        Optional<Mantenimiento> mantenimientoExistente = mr.findById(id);
        if (mantenimientoExistente.isPresent()) {
            Mantenimiento mantenimientoActualizado = mantenimientoExistente.get();

            mantenimientoActualizado.setDescripcion(mantenimiento.getDescripcion());
            mantenimientoActualizado.setFecha(mantenimiento.getFecha());
            mantenimientoActualizado.setPrecio(mantenimiento.getPrecio());
            return mr.save(mantenimientoActualizado);
        }
        throw new RuntimeException("No existe el id");
    }

    public void eliminarMantenimiento(Long id) {
        Optional<Mantenimiento> clienteId = mr.findById(id);
        if (clienteId.isPresent()) {
            mr.deleteById(id);
        }
        throw new RuntimeException("No existe el id");
    }
}
