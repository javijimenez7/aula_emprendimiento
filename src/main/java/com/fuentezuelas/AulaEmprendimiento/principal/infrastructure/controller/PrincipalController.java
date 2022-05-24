package com.fuentezuelas.AulaEmprendimiento.principal.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.repository.GaleriaRepository;
import com.fuentezuelas.AulaEmprendimiento.mail.infrastructure.repository.MailRepository;
import com.fuentezuelas.AulaEmprendimiento.principal.domain.Principal;
import com.fuentezuelas.AulaEmprendimiento.principal.infrastructure.repository.PrincipalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PrincipalController {

    @Autowired
    PrincipalRepository principalRepository;

    @Autowired
    GaleriaRepository galeriaRepository;

    @Autowired
    MailRepository mailRepository;

    @Value("${carpetaimagenes}")
    String carpeta;

    @GetMapping("/")
    public ModelAndView muestraPagina(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/about");
        modelAndView.addObject("principal", principalRepository.findAll().get(0).getDescripcion());
        modelAndView.addObject("carpeta", carpeta);

        return modelAndView;
    }

    @GetMapping(value = "/procesaDatosPrincipal")
    public void procesaDatos(@RequestParam(required = false, value = "principal") String principal){

        Principal principalTexto;
        if(principalRepository.findById(1).isPresent()) {
            principalTexto = principalRepository.findById(1).get();
            principalTexto.setDescripcion(principal);
        } else {
            principalTexto = new Principal();
            principalTexto.setDescripcion(principal);

        }
        principalRepository.save(principalTexto);

    }


    @GetMapping(value = "/principal")
    public ModelAndView principal(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/principal");
        if(principalRepository.findById(1).isPresent()) {
            modelAndView.addObject("principal", principalRepository.findById(1).get().getDescripcion());
        }
        return modelAndView;
    }
}
