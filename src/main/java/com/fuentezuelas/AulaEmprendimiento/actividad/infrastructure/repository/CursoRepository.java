package com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.curso.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, String> {
}
