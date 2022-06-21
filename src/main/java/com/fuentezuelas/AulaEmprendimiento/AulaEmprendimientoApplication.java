package com.fuentezuelas.AulaEmprendimiento;

import com.fuentezuelas.AulaEmprendimiento.ficheros.StorageService;
import com.fuentezuelas.AulaEmprendimiento.usuario.domain.Usuario;
import com.fuentezuelas.AulaEmprendimiento.usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PreDestroy;

@SpringBootApplication
public class AulaEmprendimientoApplication {


	public static void main(String[] args) {
		SpringApplication.run(AulaEmprendimientoApplication.class, args);
	}


		/*
		 @PreDestroy
		 public void onShutDown() {
			Usuario u = usuarioRepository.findById(1).get();
			u.setLogueado(false);
			usuarioRepository.save(u);
			System.out.println("no esta log");
		 }
*/
}
