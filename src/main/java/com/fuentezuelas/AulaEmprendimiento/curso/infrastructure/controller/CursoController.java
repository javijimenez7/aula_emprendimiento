package com.fuentezuelas.AulaEmprendimiento.curso.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.curso.domain.Curso;
import com.fuentezuelas.AulaEmprendimiento.curso.infrastructure.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    /**
     * Endpoint que carga la plantilla con el listado de cursos en el backend
     * @return ModelAndView
     */
    @GetMapping(value = "/listado_cursos")
    public ModelAndView cursos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_cursos");

        modelAndView.addObject("cursos", cursoRepository.findAll());

        return modelAndView;

    }

    /**
     * Endpoint que carga la plantilla con el detalle de cada curso en el backend
     * @return ModelAndView
     */
    @GetMapping(value = "/cargaPlantillaCurso/{id}")
    public ModelAndView cargaPlantilla(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_curso");

        if (!Integer.toString(id).equals("0")) {
            modelAndView.addObject("curso", cursoRepository.findById(id).get());
            modelAndView.addObject("id", id);
            return modelAndView;
        }

        modelAndView.addObject("curso", new Curso(null, null));
        modelAndView.addObject("id", 0);
        return modelAndView;

    }

    /**
     * Endpoint que guarda un curso en la base de datos
     * @param id
     * @param descripcion

     */
    @PostMapping(value = "guardaCurso")
    public void guardaCurso(@RequestParam(required = false, value = "idCurso") Integer id, @RequestParam(required = false, value = "descripcion") String descripcion) {
        Curso cur = new Curso();
        if (cursoRepository.findById(id).isPresent()) {
            cur = cursoRepository.findById(id).orElseThrow();
            cur.setDescripcion(descripcion);

        } else {
            cur.setDescripcion(descripcion);

        }
        cursoRepository.save(cur);

    }

    /**
     * Endpoint que elimina un curso de la base de datos
     * @param id
     */
    @PostMapping(value = "eliminaCurso")
    public void eliminaCurso(@RequestParam(required = false, value = "idCurso") Integer id) {
        Curso act = cursoRepository.findById(id).orElseThrow();
        cursoRepository.delete(act);
    }

}
