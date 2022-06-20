package com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@RestController
public class ActividadController {

    @Autowired
    ActividadRepository actividadRepository;


    /**
     * Endpoint donde se devuelve la plantilla con el listado de actividades en el backend
     *
     * @return ModelAndView
     */
    @GetMapping(value = "/listado_actividades")
    public ModelAndView actividades() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_actividades");

        modelAndView.addObject("actividades", actividadRepository.findAll());

        return modelAndView;

    }

    /**
     * Endpoint donde se devuelve la plantilla con el listado de actividades en el frontend
     *
     * @return ModelAndView
     */
    @GetMapping(value = "/actividades")
    public ModelAndView listado_actividades() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/actividades");

        modelAndView.addObject("actividades", actividadRepository.findAll());

        return modelAndView;

    }

    /**
     * Endpoint donde se devuelve la plantilla con el detalle de una actividad en el backend
     * @param id
     * @return ModelAndView
     */
    @GetMapping(value = "/detalle_actividad/{id}")
    public ModelAndView detalle_actividad(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/detalle_actividad");

        modelAndView.addObject("actividad", actividadRepository.findById(id).orElseThrow());

        return modelAndView;

    }

    /**
     * Endpoint donde se devuelve la plantilla con el detalle de una actividad en el frontend
     * @param id
     * @return ModelAndView
     */

    @GetMapping(value = "/cargaPlantillaActividad/{id}")
    public ModelAndView cargaPlantilla(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_actividad");
        if (!Integer.toString(id).equals("0")) {
            modelAndView.addObject("actividad", actividadRepository.findById(id).get());
            modelAndView.addObject("id", id);
            return modelAndView;
        }

        modelAndView.addObject("actividad", new Actividad(null, null, null, null, null));
        modelAndView.addObject("id", 0);
        return modelAndView;

    }

    /**
     * Endpoint que guarda una actividad en la base de datos
     * @param id
     * @param archivo
     * @param descripcion
     * @param nombre
     *
     */
    @PostMapping(value = "guardaActividad")
    public void guardaActividad(@RequestParam(required = false, value = "idActividad") Integer id, @RequestParam(required = false, value = "nombre") String nombre, @RequestParam(required = false, value = "archivo") String archivo, @RequestParam(required = false, value = "descripcion") String descripcion) {
        Actividad act = new Actividad();
        if (actividadRepository.findById(id).isPresent()) {
            act = actividadRepository.findById(id).orElseThrow();
            act.setArchivo(archivo);
            act.setDescripcion(descripcion);
            act.setFechaCreacion(LocalDate.now());
            act.setNombre(nombre);
        } else {
            act.setArchivo(archivo);
            act.setDescripcion(descripcion);
            act.setNombre(nombre);
            act.setFechaCreacion(LocalDate.now());
        }
        actividadRepository.save(act);

    }

    /**
     * Endpoint que elimina una actividad de la base de datos
     * @param id
     *
     */

    @PostMapping(value = "eliminaActividad")
    public void eliminaActividad(@RequestParam(required = false, value = "idActividad") Integer id) {
        Actividad act = actividadRepository.findById(id).orElseThrow();
        actividadRepository.delete(act);
    }
}
