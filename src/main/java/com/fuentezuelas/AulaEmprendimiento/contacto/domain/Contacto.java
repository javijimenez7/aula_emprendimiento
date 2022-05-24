package com.fuentezuelas.AulaEmprendimiento.contacto.domain;

import com.fuentezuelas.AulaEmprendimiento.StringPrefixedSequenceIdGenerator;
import com.fuentezuelas.AulaEmprendimiento.curso.domain.Curso;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contacto")
@NoArgsConstructor
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCO")
    @GenericGenerator(
            name = "seqCO",
            strategy = "com.fuentezuelas.AulaEmprendimiento.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CON"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
            }
    )
    private String id;

    @NotNull
    private String nombre;

    private String apellidos;

    private String correo;

    private String telefono;

    private String asunto;

    private String mensaje;

    private String EmpresaNombre;

    private Boolean esEmpresa;

    @ManyToOne
    @JoinColumn(name = "fk_curso")
    private Curso curso;

}
