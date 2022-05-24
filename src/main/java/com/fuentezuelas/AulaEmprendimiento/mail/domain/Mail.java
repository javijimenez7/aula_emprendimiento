package com.fuentezuelas.AulaEmprendimiento.mail.domain;

import com.fuentezuelas.AulaEmprendimiento.curso.domain.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "mail")
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idMail;

    private LocalDate date;

    private String emailto;

    private String subject;

    public Mail(LocalDate now, String s, String s1) {
        date = now;
        emailto = s;
        subject = s1;
    }
}
