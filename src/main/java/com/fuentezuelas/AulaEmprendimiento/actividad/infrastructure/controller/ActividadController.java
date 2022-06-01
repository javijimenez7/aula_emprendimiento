package com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ActividadController {

    @Autowired
    ActividadRepository actividadRepository;

    @GetMapping(value = "/listado_actividades")
    public ModelAndView actividades() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_actividades");

        modelAndView.addObject("actividades", actividadRepository.findAll());

        return modelAndView;

    }

    @GetMapping(value = "/actividades")
    public ModelAndView listado_actividades() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/actividades");

        modelAndView.addObject("actividades", actividadRepository.findAll());

        return modelAndView;

    }

    @GetMapping(value = "/detalle_actividad/{id}")
    public ModelAndView detalle_actividad(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/detalle_actividad");

        modelAndView.addObject("actividad", actividadRepository.findById(id).orElseThrow());

        return modelAndView;

    }


    @GetMapping(value = "/cargaPlantillaActividad/{id}")
    public ModelAndView cargaPlantilla(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_actividad");
        if (!id.equals("0")) {
            modelAndView.addObject("actividad", actividadRepository.findById(id).get());
            modelAndView.addObject("id", id);
            return modelAndView;
        }

        modelAndView.addObject("actividad", new Actividad(null, null, null, null));
        modelAndView.addObject("id", 0);
        return modelAndView;

    }

    @PostMapping(value = "guardaActividad")
    public void guardaActividad(@RequestParam(required = false, value = "idActividad") String id, @RequestParam(required = false, value = "nombre") String nombre, @RequestParam(required = false, value = "archivo") String archivo, @RequestParam(required = false, value = "descripcion") String descripcion) {
        Actividad act = new Actividad();
        if (actividadRepository.findById(id).isPresent()) {
            act = actividadRepository.findById(id).orElseThrow();
            act.setArchivo(archivo);
            act.setDescripcion(descripcion);
            act.setNombre(nombre);
        } else {
            act.setArchivo(archivo);
            act.setDescripcion(descripcion);
            act.setNombre(nombre);
        }
        actividadRepository.save(act);

    }


    @PostMapping(value = "eliminaActividad")
    public void guardaActividad(@RequestParam(required = false, value = "idActividad") String id) {
        Actividad act = actividadRepository.findById(id).orElseThrow();
        actividadRepository.delete(act);
    }
}
