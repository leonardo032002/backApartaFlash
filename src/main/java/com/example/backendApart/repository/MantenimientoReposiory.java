package com.example.backendApart.repository;


import com.example.backendApart.entity.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoReposiory extends JpaRepository<Mantenimiento, Long> {
}
