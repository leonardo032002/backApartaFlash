package com.example.backendApart.repository;

import com.example.backendApart.entity.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReciboRepository extends JpaRepository<Recibo, Long> {
}
