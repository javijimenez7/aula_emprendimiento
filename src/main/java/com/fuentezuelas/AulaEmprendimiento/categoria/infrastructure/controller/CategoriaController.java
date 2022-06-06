package com.fuentezuelas.AulaEmprendimiento.categoria.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import com.fuentezuelas.AulaEmprendimiento.categoria.domain.Categoria;
import com.fuentezuelas.AulaEmprendimiento.categoria.infrastructure.repository.CategoriaRepository;
import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping(value = "/listado_categorias")
    public ModelAndView mails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_categorias");
        modelAndView.addObject("categorias", categoriaRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/cargaPlantillaCategoria/{id}")
    public ModelAndView cargaPlantillaImagen(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_categoria");
        if (!Integer.toString(id).equals("0")) {
            modelAndView.addObject("categoria", categoriaRepository.findById(id).get());
            modelAndView.addObject("id", id);
            return modelAndView;
        }

        modelAndView.addObject("categoria", new Categoria(null,null));
        modelAndView.addObject("id", 0);
        return modelAndView;

    }

    @PostMapping(value = "guardaCategoria")
    public void guardaActividad(@RequestParam(required = false, value = "idCategoria") Integer id, @RequestParam(required = false, value = "titulo") String titulo) {
        Categoria img = new Categoria();
        if (categoriaRepository.findById(id).isPresent()) {
            img = categoriaRepository.findById(id).orElseThrow();
            img.setTitulo(titulo);
        } else {
            img.setTitulo(titulo);
        }
        categoriaRepository.save(img);

    }

    @PostMapping(value = "eliminaCategoria")
    public void guardaActividad(@RequestParam(required = false, value = "idCategoria") Integer id) {
        Categoria act = categoriaRepository.findById(id).orElseThrow();
        categoriaRepository.delete(act);
    }

}
