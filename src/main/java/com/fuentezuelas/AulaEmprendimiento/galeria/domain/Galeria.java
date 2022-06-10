package com.fuentezuelas.AulaEmprendimiento.galeria.domain;


import com.fuentezuelas.AulaEmprendimiento.categoria.domain.Categoria;
import lombok.*;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "fk_categoria") @EqualsAndHashCode.Exclude @ToString.Exclude
    private Categoria categoria;
    
    private String titulo;

    public Galeria(String substring, Categoria catt, String tit) {
        archivo = substring;
        categoria = catt;
        titulo = tit;


    }
}
