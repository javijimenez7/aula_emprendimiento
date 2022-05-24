package com.fuentezuelas.AulaEmprendimiento.usuario.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Data
public class Usuario{

    @Id
    private Integer id=1;

    private String user;
    private String password;
    private Boolean logueado;



}
