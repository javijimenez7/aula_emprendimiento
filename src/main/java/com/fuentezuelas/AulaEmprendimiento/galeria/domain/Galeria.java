package com.fuentezuelas.AulaEmprendimiento.galeria.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Galeria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    private String archivo;
    private String titulo;
    private String categoria;

    public Galeria(String substring, String titulo, String categoria) {
        archivo = substring;
        titulo = titulo;
        categoria = categoria;
    }
}
