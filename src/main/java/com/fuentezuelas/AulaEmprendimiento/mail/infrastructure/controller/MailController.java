package com.fuentezuelas.AulaEmprendimiento.mail.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.mail.application.MailSenderService;
import com.fuentezuelas.AulaEmprendimiento.mail.infrastructure.repository.MailRepository;
import com.fuentezuelas.AulaEmprendimiento.principal.domain.Principal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.awt.print.Pageable;


@RestController
public class MailController {
    @Autowired
    MailRepository mailRepository;

    @Autowired
    MailSenderService mailSenderService;



    @GetMapping(value = "/mails")
    public ModelAndView mails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_mail");

        modelAndView.addObject("mails", mailRepository.findAll());

        return modelAndView;

    }

    @GetMapping(value = "/cargaPlantillaCorreo/{id}")
    public ModelAndView cargaPlantilla(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantillaCorreo");
        modelAndView.addObject("mail", mailRepository.findById(id).get());
        modelAndView.addObject("id", id);

        return modelAndView;
    }
    @PostMapping(value = "enviaCorreo")
    public void enviaCorreo(@RequestParam(required = false, value = "idEmail") Integer id, @RequestParam(required = false, value = "body") String body, @RequestParam(required = false, value = "subject") String subject, @RequestParam(required = false, value = "email") String email){

        System.out.println(body);
        try {
            mailSenderService.sendMail(
                email,
                subject,
                body
        );
        } catch (MessagingException e) {
            e.getMessage();
        }

        mailRepository.delete(mailRepository.findById(id).get());

    }

}
