package com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.controller;


import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.repository.GaleriaRepository;
import com.fuentezuelas.AulaEmprendimiento.mail.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
public class GaleriaController {

    @Autowired
    GaleriaRepository galeriaRepository;

    @GetMapping(value = "/galeria")
    public ModelAndView mails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/subidaImagenes");
       /* modelAndView.addObject("imagenes", galeriaRepository.findAll());*/
        return modelAndView;
    }
    @GetMapping(value = "/enviaImagenes")
    public ResponseEntity enviaFormulario(@RequestParam(required = false, value = "imagenes") List<String> imagenes){

        for (int i = 0; i <= imagenes.size()-1 ; i++) {
            Galeria galeria = new Galeria(imagenes.get(i).replace("[","").replace("]", "").substring(1, imagenes.get(i).length()-3));
            galeriaRepository.save(galeria);
        }

        return ResponseEntity.ok("Enviado");
    }
}
