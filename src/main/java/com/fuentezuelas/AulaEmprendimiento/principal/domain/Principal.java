package com.fuentezuelas.AulaEmprendimiento.principal.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "principal")
@Data
@NoArgsConstructor

public class Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Lob
    @NotNull
    private String descripcion;

}
