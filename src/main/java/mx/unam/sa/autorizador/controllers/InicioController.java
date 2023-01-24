/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author israel1971
 */
@Controller
@RequestMapping("/")
public class InicioController {
    @GetMapping
    public ResponseEntity<String> inicial() {
        String salida = "<p>Proyecto Autorizador</p>";
        return ResponseEntity.ok().body(salida);
    }

}
