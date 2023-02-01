/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.controllers;

import java.util.ArrayList;
import java.util.List;
import mx.unam.sa.autorizador.controllers.dtos.UsuariosDTO;
import mx.unam.sa.autorizador.entities.Usuario;
import mx.unam.sa.autorizador.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author israel1971
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepo usuaRepo;

    @GetMapping
    public ResponseEntity<String> inicial() {
        String salida = "<p>usuarios</p>";
        return ResponseEntity.ok().body(salida);
    }

    //1. ¿Qué principio solid no estamos aplicando?
    //2. ¿Cómó pasamos a DTO?
    @GetMapping("/getUsuarios/{pagina}")
    public ResponseEntity<Page<Usuario>> getDatosSE(@PathVariable("pagina") Integer pagina) {
        Page<Usuario> usuarios;

        try {
//            //inicia en 0, son 5 elementos por página
            Pageable pageable = PageRequest.of(pagina-1, 5);
            usuarios = usuaRepo.findAll(pageable);
        } catch (Exception e) {
            throw new IllegalStateException("Error en se rvicio al recuperar circular");
        }

        return ResponseEntity.ok().body(usuarios);
    }

}
