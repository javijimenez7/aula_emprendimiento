package com.fuentezuelas.AulaEmprendimiento.usuario.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUser(String user);
}
