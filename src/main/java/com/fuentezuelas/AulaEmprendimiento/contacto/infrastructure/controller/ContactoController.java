package com.fuentezuelas.AulaEmprendimiento.contacto.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository.ActividadRepository;
import com.fuentezuelas.AulaEmprendimiento.contacto.domain.Contacto;
import com.fuentezuelas.AulaEmprendimiento.contacto.infrastructure.repository.ContactoRepository;
import com.fuentezuelas.AulaEmprendimiento.curso.domain.Curso;
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
    ContactoRepository contactoRepository;


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
        String cont;
        Mail mail = new Mail(LocalDate.now(), contacto.get(0).substring(2,contacto.get(0).length()-1), contacto.get(2).substring(1,contacto.get(2).length()-1),  contacto.get(5).substring(1,contacto.get(5).length()-1) );


        Curso curso = cursoRepository.findById(Integer.parseInt(contacto.get(7).substring(1,contacto.get(7).length()-2))).get();
        if(contacto.get(6).length()>2){
            cont = contacto.get(6).substring(1,contacto.get(6).length()-1);
            curso = null;
        } else {
            cont = "NULO";
        }

        Contacto contacto1 = new Contacto(contacto.get(0).substring(2,contacto.get(0).length()-1), contacto.get(1).substring(1,contacto.get(1).length()-1),contacto.get(2).substring(1,contacto.get(2).length()-1),contacto.get(3).substring(1,contacto.get(3).length()-1), contacto.get(5).substring(1,contacto.get(5).length()-1), cont, curso);
        contactoRepository.save(contacto1);
        mailRepository.save(mail);
        return ResponseEntity.ok("ENVIADO");
    }

    @GetMapping(value = "/contactos")
    public ModelAndView contactos(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_contactos");

        modelAndView.addObject("contactos", contactoRepository.findAll());

        return modelAndView;

    }



}
