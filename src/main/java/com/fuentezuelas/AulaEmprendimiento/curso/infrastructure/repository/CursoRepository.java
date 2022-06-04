package com.fuentezuelas.AulaEmprendimiento.curso.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.curso.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, String> {
}
