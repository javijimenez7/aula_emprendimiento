package com.fuentezuelas.AulaEmprendimiento.curso.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import com.fuentezuelas.AulaEmprendimiento.actividad.infrastructure.repository.ActividadRepository;
import com.fuentezuelas.AulaEmprendimiento.curso.domain.Curso;
import com.fuentezuelas.AulaEmprendimiento.curso.infrastructure.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping(value = "/listado_cursos")
    public ModelAndView cursos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_cursos");

        modelAndView.addObject("cursos", cursoRepository.findAll());

        return modelAndView;

    }
    @GetMapping(value = "/cargaPlantillaCurso/{id}")
    public ModelAndView cargaPlantilla(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_curso");

        if (!id.equals("0")) {
            modelAndView.addObject("curso", cursoRepository.findById(id).get());
            modelAndView.addObject("id", id);
            return modelAndView;
        }

        modelAndView.addObject("curso", new Curso(null, null));
        modelAndView.addObject("id", 0);
        return modelAndView;

    }

    @PostMapping(value = "guardaCurso")
    public void guardaCurso(@RequestParam(required = false, value = "idCurso") String id, @RequestParam(required = false, value = "descripcion") String descripcion) {
        Curso cur = new Curso();
        if (cursoRepository.findById(id).isPresent()) {
            cur = cursoRepository.findById(id).orElseThrow();
            cur.setDescripcion(descripcion);

        } else {
            cur.setDescripcion(descripcion);

        }
        cursoRepository.save(cur);

    }

    @PostMapping(value = "eliminaCurso")
    public void guardaActividad(@RequestParam(required = false, value = "idCurso") String id) {
        Curso act = cursoRepository.findById(id).orElseThrow();
        cursoRepository.delete(act);
    }

}
