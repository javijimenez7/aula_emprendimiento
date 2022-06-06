package com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.controller;


import ch.qos.logback.classic.joran.action.InsertFromJNDIAction;
import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import com.fuentezuelas.AulaEmprendimiento.categoria.domain.Categoria;
import com.fuentezuelas.AulaEmprendimiento.categoria.infrastructure.repository.CategoriaRepository;
import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.repository.GaleriaRepository;
import com.fuentezuelas.AulaEmprendimiento.mail.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class GaleriaController {

    @Autowired
    GaleriaRepository galeriaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping(value = "/galeria")
    public ModelAndView mails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_imagenes");
        modelAndView.addObject("imagenes", galeriaRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/portfolio")
    public ModelAndView imagenes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/Portfolio");
        modelAndView.addObject("imagenes", galeriaRepository.findAll());
        modelAndView.addObject("categorias", categoriaRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/cargaPlantillaImagen/{id}")
    public ModelAndView cargaPlantillaImagen(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_imagen");
        if (!Integer.toString(id).equals("0")) {
            modelAndView.addObject("imagen", galeriaRepository.findById(id).get());
            modelAndView.addObject("id", id);
            modelAndView.addObject("categorias", categoriaRepository.findAll());
            return modelAndView;
        }

        modelAndView.addObject("imagen", new Galeria(null, null, null));
        modelAndView.addObject("id", 0);
        modelAndView.addObject("categorias", categoriaRepository.findAll());
        return modelAndView;

    }


    @PostMapping(value = "guardaImagen")
    public void guardaActividad(@RequestParam(required = false, value = "idImagen") Integer id, @RequestParam(required = false, value = "titulo") String titulo, @RequestParam(required = false, value = "categoria") String categoria, @RequestParam(required = false, value = "archivo") String archivo) {
        Galeria img = new Galeria();
        if (galeriaRepository.findById(id).isPresent()) {
            img = galeriaRepository.findById(id).orElseThrow();
            img.setArchivo(archivo);
            img.setTitulo(titulo);
            img.setCategoria(categoriaRepository.findById(parseInt(categoria)).get());
        } else {
            img.setArchivo(archivo);
            img.setTitulo(titulo);
            img.setCategoria(categoriaRepository.findById(parseInt(categoria)).get());
        }
        galeriaRepository.save(img);

    }

    @PostMapping(value = "eliminaImagen")
    public void guardaActividad(@RequestParam(required = false, value = "idImagen") Integer id) {
        Galeria act = galeriaRepository.findById(id).orElseThrow();
        galeriaRepository.delete(act);
    }
}
