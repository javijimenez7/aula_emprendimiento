package com.fuentezuelas.AulaEmprendimiento.categoria.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    Categoria findByTitulo(String titulo);
}
