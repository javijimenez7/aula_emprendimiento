package com.fuentezuelas.AulaEmprendimiento;

import com.fuentezuelas.AulaEmprendimiento.usuario.domain.Usuario;
import com.fuentezuelas.AulaEmprendimiento.usuario.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class InicioAplicacion implements CommandLineRunner {


    private final UsuarioRepository usuarioRepository;



    @Override
    public void run(String... args) throws Exception {

        Usuario u = new Usuario(1,"admin","1234",false);


        if (usuarioRepository.findById(u.getId()).isEmpty()){
            usuarioRepository.save(u);
        }

    }
}
