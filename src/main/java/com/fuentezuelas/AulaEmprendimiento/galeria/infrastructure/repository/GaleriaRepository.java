package com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface GaleriaRepository extends JpaRepository<Galeria, Integer> {
}
