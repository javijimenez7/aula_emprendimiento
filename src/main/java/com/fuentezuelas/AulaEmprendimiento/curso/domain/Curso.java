package com.fuentezuelas.AulaEmprendimiento.curso.domain;

import com.fuentezuelas.AulaEmprendimiento.StringPrefixedSequenceIdGenerator;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "curso")
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCu")
    @GenericGenerator(
            name = "seqCu",
            strategy = "com.fuentezuelas.AulaEmprendimiento.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CUR"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
            }
    )
    private String id;

    @NotNull
    private String descripcion;


}
