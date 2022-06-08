package com.fuentezuelas.AulaEmprendimiento.usuario.infrastructure.controller;

import com.fuentezuelas.AulaEmprendimiento.categoria.domain.Categoria;
import com.fuentezuelas.AulaEmprendimiento.principal.infrastructure.repository.PrincipalRepository;
import com.fuentezuelas.AulaEmprendimiento.usuario.domain.Usuario;
import com.fuentezuelas.AulaEmprendimiento.usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    PrincipalRepository principalRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/admin")
    public ModelAndView recogeDatos(){
        ModelAndView modelAndView = new ModelAndView();
        if(!usuarioRepository.findById(1).get().getLogueado()){
            modelAndView.setViewName("plantillaBack/login");
        } else {
            modelAndView.setViewName("plantillaBack/admin");
            if (principalRepository.findById(1).isPresent()) {
                modelAndView.addObject("principal", principalRepository.findById(1).get().getDescripcion());
            }
            if (usuarioRepository.findById(1).isPresent()) {
                modelAndView.addObject("usuario", usuarioRepository.findById(1).get());
            }
        }
        return modelAndView;
    }

    @PostMapping(value = "compruebaUsuario")
    public ResponseEntity<Void> compruebaUsuario(@RequestParam(required = false, value = "usuario") String usuario, @RequestParam(required = false, value = "password") String password) {

        Optional<Usuario> user = usuarioRepository.findByUser(usuario);
        ModelAndView modelAndView = new ModelAndView();
        if(user.isPresent() && user.get().getPassword().equals(password)) {
            user.get().setLogueado(true);
            usuarioRepository.save(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            user.get().setLogueado(false);
            usuarioRepository.save(user.get());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "cierrasesion")
    public ResponseEntity<Void> logout() {

        Usuario usuario = usuarioRepository.findById(1).orElseThrow();
        usuario.setLogueado(false);
        usuarioRepository.save(usuario);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping(value = "/backend")
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/login");

        return modelAndView;
    }

    @GetMapping(value = "/cargaPlantillaUsuario")
    public ModelAndView cargaPlantillaImagen() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plantillaBack/plantilla_usuario");

        modelAndView.addObject("usuario", usuarioRepository.findById(1).get());
        modelAndView.addObject("id", 1);
        return modelAndView;

    }

    @PostMapping(value = "guardaUsuario")
    public void guardaActividad(@RequestParam(required = false, value = "idUsuario") Integer id, @RequestParam(required = false, value = "usuario") String usuario, @RequestParam(required = false, value = "password") String password) {
        Usuario us = usuarioRepository.findById(id).orElseThrow();
        us.setUser(usuario);
        us.setPassword(password);

        usuarioRepository.save(us);

    }
}
