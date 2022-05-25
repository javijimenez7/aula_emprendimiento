package com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ActividadController {

    @Autowired
    ActividadRepository actividadRepository;

    @GetMapping(value = "/actividades")
    public ModelAndView actividades() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_actividades");

        modelAndView.addObject("actividades", actividadRepository.findAll());

        return modelAndView;

    }

    @GetMapping(value = "/cargaPlantillaActividad/{id}")
    public ModelAndView cargaPlantilla(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_actividad");
        modelAndView.addObject("actividad", actividadRepository.findById(id).get());
        modelAndView.addObject("id", id);

        return modelAndView;
    }
}
