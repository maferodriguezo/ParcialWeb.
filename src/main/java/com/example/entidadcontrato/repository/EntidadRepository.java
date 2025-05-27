package com.example.entidadcontrato.repository;

import com.example.entidadcontrato.model.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {
}