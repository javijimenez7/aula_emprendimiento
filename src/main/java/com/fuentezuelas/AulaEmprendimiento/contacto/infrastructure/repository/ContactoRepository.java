package com.fuentezuelas.AulaEmprendimiento.contacto.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.contacto.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, String> {
}
