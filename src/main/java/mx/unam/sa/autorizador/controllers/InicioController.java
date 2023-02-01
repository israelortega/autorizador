/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.controllers;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@EnableEncryptableProperties
public class InicioController {

    @Value("${pom.version}")
    private String pomVersion;
    
    //Comentar para salir a producción
    @Value("${jasypt.encryptor.password}")
    private String encriptor;

    @Value("${app.dependencia}")
    private String dependencia;
    
    @GetMapping
    public ResponseEntity<String> inicial() {
        String salida = "<p>Proyecto Autorizador</p>";
        salida+= "<p>Versión: " + pomVersion + "</p>";
        salida+= "<p>Encriptor: " + encriptor + "</p>";
        salida+= "<p>Dependencia: " + dependencia + "</p>";
        return ResponseEntity.ok().body(salida);
    }

}
