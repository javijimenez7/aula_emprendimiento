package com.fuentezuelas.AulaEmprendimiento.categoria.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.actividad.domain.Actividad;
import com.fuentezuelas.AulaEmprendimiento.categoria.domain.Categoria;
import com.fuentezuelas.AulaEmprendimiento.categoria.infrastructure.repository.CategoriaRepository;
import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.repository.GaleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    GaleriaRepository galeriaRepository;

    /**
     * Endpoint que carga la plantilla del listado de categorias en el backend
     * @return ModelAndView
     */
    @GetMapping(value = "/listado_categorias")
    public ModelAndView mails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_categorias");
        modelAndView.addObject("categorias", categoriaRepository.findAll());
        return modelAndView;
    }

    /**
     * Endpoint que carga la plantilla del detalle de una categoria en el backend
     * @param id
     * @return ModelAndView
     */
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


    /**
     * Endpoint que guarda una categoria en la base de datos
     * @param id
     * @param titulo
     *
     */
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

    /**
     * Endpoint que elimina una categoria de la base de datos
     * @param id
     * @return ResponseEntity<String>
     *
     */
    @PostMapping(value = "eliminaCategoria")
    public ResponseEntity<String> guardaActividad(@RequestParam(required = false, value = "idCategoria") Integer id) throws Exception {
        Categoria act = categoriaRepository.findById(id).orElseThrow();
        if(galeriaRepository.findByCategoria(act).isPresent()){
           return new ResponseEntity<String>("No puedes", HttpStatus.BAD_REQUEST );
        } else {
            categoriaRepository.delete(act);
            return new ResponseEntity<String>(HttpStatus.OK );
        }

    }

}
