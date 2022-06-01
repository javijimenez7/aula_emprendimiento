package com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.controller;


import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.repository.GaleriaRepository;
import com.fuentezuelas.AulaEmprendimiento.mail.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        modelAndView.setViewName("plantillaBack/tabla_imagenes");
        modelAndView.addObject("imagenes", galeriaRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/portfolio")
    public ModelAndView imagenes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/Portfolio");
        modelAndView.addObject("imagenes", galeriaRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/cargaPlantillaImagen/{id}")
    public ModelAndView cargaPlantillaImagen(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_imagen");
        if (!id.equals("0")) {
            modelAndView.addObject("imagen", galeriaRepository.findById(id).get());
            modelAndView.addObject("id", id);
            return modelAndView;
        }

        modelAndView.addObject("imagen", new Galeria(null, null, null, null));
        modelAndView.addObject("id", 0);
        return modelAndView;

    }
//    @GetMapping(value = "/enviaImagenes")
//    public ResponseEntity enviaFormulario(@RequestParam(required = false, value = "imagenes") List<String> imagenes){
//
//
//        for (int i = 0; i <= imagenes.size()-1 ; i++) {
//            Galeria galeria = new Galeria(imagenes.get(i).replace("[","").replace("]", "").substring(1, imagenes.get(i).length()-2), "f","d");
//            galeriaRepository.save(galeria);
//        }
//
//        return ResponseEntity.ok("Enviado");
//    }


    @PostMapping(value = "guardaImagen")
    public void guardaActividad(@RequestParam(required = false, value = "idImagen") Integer id, @RequestParam(required = false, value = "titulo") String titulo, @RequestParam(required = false, value = "archivo") String archivo) {
        Galeria img = new Galeria();
        if (galeriaRepository.findById(id).isPresent()) {
            img = galeriaRepository.findById(id).orElseThrow();
            img.setArchivo(archivo);
            img.setTitulo(titulo);
        } else {
            img.setArchivo(archivo);
            img.setTitulo(titulo);
        }
        galeriaRepository.save(img);

    }
}
