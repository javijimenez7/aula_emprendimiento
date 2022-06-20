package com.fuentezuelas.AulaEmprendimiento.principal.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository.ActividadRepository;
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
    ActividadRepository actividadRepository;

    @Autowired
    MailRepository mailRepository;

    @Value("${carpetaimagenes}")
    String carpeta;

    /**
     * Endpoint que carga la plantilla principal en el frontend
     * @return ModelAndView
     */
    @GetMapping("/")
    public ModelAndView muestraPagina(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/about");
        if(principalRepository.findAll().size() == 0){
            modelAndView.addObject("principal", "Texto prueba");
        } else {
            modelAndView.addObject("principal", principalRepository.findAll().get(0).getDescripcion());
        }
        modelAndView.addObject("carpeta", carpeta);
        modelAndView.addObject("actividades", actividadRepository.findAll());

        return modelAndView;
    }

    /**
     * Endpoint que se encarga de guardar el contenido de la pestaña principal en la base de datos
     * @param principal
     * @return ModelAndView
     */
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


    /**
     * Endpoint que carga la plantilla con el texto a modificar en el backend
     * @return ModelAndView
     */
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
