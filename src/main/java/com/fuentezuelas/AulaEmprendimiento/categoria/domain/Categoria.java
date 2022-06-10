package com.fuentezuelas.AulaEmprendimiento.categoria.domain;

import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    private String titulo;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Galeria> imagenes;


    public Categoria(Integer id1, String titulo1) {
        id = id1;
        titulo = titulo1;
    }
}