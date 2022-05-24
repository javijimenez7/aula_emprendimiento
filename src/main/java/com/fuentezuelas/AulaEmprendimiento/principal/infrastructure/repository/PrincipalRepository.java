package com.fuentezuelas.AulaEmprendimiento.principal.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.principal.domain.Principal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrincipalRepository extends JpaRepository<Principal, Integer> {
}
