package com.fuentezuelas.AulaEmprendimiento.contacto.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository.ActividadRepository;
import com.fuentezuelas.AulaEmprendimiento.curso.infrastructure.repository.CursoRepository;
import com.fuentezuelas.AulaEmprendimiento.mail.application.MailSenderService;
import com.fuentezuelas.AulaEmprendimiento.mail.domain.Mail;
import com.fuentezuelas.AulaEmprendimiento.mail.infrastructure.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ContactoController {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    MailRepository mailRepository;

    @Autowired
    MailSenderService mailSenderService;

    @GetMapping("/contactanos")
    public ModelAndView muestraPagina(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/contact");
        modelAndView.addObject("cursos", cursoRepository.findAll());
        return modelAndView;
    }

    @PostMapping(value = "enviaformulario")
    public ResponseEntity enviaFormulario(@RequestParam(required = false, value = "contacto") List<String> contacto){

        Mail mail = new Mail(LocalDate.now(), contacto.get(0).substring(2,contacto.get(0).length()-1), contacto.get(2).substring(1,contacto.get(2).length()-1),  contacto.get(5).substring(1,contacto.get(5).length()-1) );
        mailRepository.save(mail);
        return ResponseEntity.ok("ENVIADO");
    }



}
