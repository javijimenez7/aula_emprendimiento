package com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad, String> {
}
