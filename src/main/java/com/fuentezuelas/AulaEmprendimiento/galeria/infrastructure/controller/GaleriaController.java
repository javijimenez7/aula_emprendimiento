package com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.controller;


import com.fuentezuelas.AulaEmprendimiento.categoria.infrastructure.repository.CategoriaRepository;
import com.fuentezuelas.AulaEmprendimiento.ficheros.FileSystemStorageService;
import com.fuentezuelas.AulaEmprendimiento.galeria.domain.Galeria;
import com.fuentezuelas.AulaEmprendimiento.galeria.infrastructure.repository.GaleriaRepository;
import com.fuentezuelas.AulaEmprendimiento.principal.infrastructure.repository.PrincipalRepository;
import com.fuentezuelas.AulaEmprendimiento.usuario.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static java.lang.Integer.parseInt;

@RestController
@AllArgsConstructor
public class GaleriaController {
    @Autowired
    GaleriaRepository galeriaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    PrincipalRepository principalRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    private final FileSystemStorageService storageService;

    @Autowired
    public GaleriaController(FileSystemStorageService storageService) {
        this.storageService = storageService;
    }
    /**
     * Endpoint que carga la plantilla con el listado de imagenes en el backend
     * @return ModelAndView
     */
    @GetMapping(value = "/galeria")
    public ModelAndView mails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/tabla_imagenes");
        modelAndView.addObject("imagenes", galeriaRepository.findAll());
        return modelAndView;
    }

    /**
     * Endpoint que carga la plantilla con el listado de imagenes en el frontend
     * @return ModelAndView
     */
    @GetMapping(value = "/portfolio")
    public ModelAndView imagenes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaCorporativa/portfolio");
        modelAndView.addObject("imagenes", galeriaRepository.findAll());
        modelAndView.addObject("categorias", categoriaRepository.findAll());
        return modelAndView;
    }

    /**
     * Endpoint que carga la plantilla del detalle de una imagen en el backend
     * @param id
     * @return ModelAndView
     */
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


    /**
     * Endpoint que guarda una imagen en la base de datos
     * @param id
     * @param file
     * @param categoria
     * @param titulo
     * */
    @PostMapping(value = "guardaImagen")
    public ModelAndView guardaImagen(@RequestParam(required = false, value = "imagen_id_b") Integer id, @RequestParam(required = false, value = "imagen_titulo") String titulo, @RequestParam(required = false, value = "imagen_categoria") String categoria, @RequestParam("imagen_archivo") MultipartFile file,
                             RedirectAttributes redirectAttributes) {

        Galeria img = new Galeria();
        storageService.store(file);
        if(!id.equals(null)) {
            if (galeriaRepository.findById(id).isPresent()) {
                img = galeriaRepository.findById(id).orElseThrow();
                img.setArchivo(file.getOriginalFilename());
                img.setTitulo(titulo);
                img.setCategoria(categoriaRepository.findById(parseInt(categoria)).get());
            } else {
                img.setArchivo(file.getOriginalFilename());
                img.setTitulo(titulo);
                img.setCategoria(categoriaRepository.findById(parseInt(categoria)).get());
            }
            galeriaRepository.save(img);
        }
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("plantillaBack/admin");
            modelAndView.addObject("principal", principalRepository.findById(1).get().getDescripcion());
            modelAndView.addObject("usuario", usuarioRepository.findById(1).get());
            redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return modelAndView;

    }

    /**
     * Endpoint que elimina una imagen de la base de datos
     * @param id
     */
    @PostMapping(value = "eliminaImagen")
    public void eliminaImagen(@RequestParam(required = false, value = "idImagen") Integer id) {
        Galeria act = galeriaRepository.findById(id).orElseThrow();
        galeriaRepository.delete(act);
    }

}
