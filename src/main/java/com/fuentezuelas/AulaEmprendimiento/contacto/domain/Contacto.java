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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nombre;

    private String apellidos;

    private String correo;

    private String telefono;

    private String asunto;

    private String EmpresaNombre;


    @ManyToOne
    @JoinColumn(name = "fk_curso")
    private Curso curso;

    public Contacto(String nombre, String apellidos, String correo, String telefono, String asunto, String empresa, Curso curso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.asunto = asunto;
        this.EmpresaNombre = empresa;
        this.curso = curso;
    }
}
