/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.controllers;

import java.util.Optional;
import mx.unam.sa.autorizador.controllers.dtos.SistEstrategicoDTO;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import mx.unam.sa.autorizador.services.SistemasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/sistemas")
public class SistemasController {
    @Autowired
    SistemasService sistemasService;

    @GetMapping("/getDatosSE/{valor1}")
    public ResponseEntity<SistEstrategicoDTO> getDatosSE( @PathVariable("valor1") Integer valor1) {

        try {
            SistEstrategicoDTO salida = sistemasService.getDatosSistema(valor1);
            return ResponseEntity.ok().body(salida);
        } catch (Exception e) {
            SistEstrategicoDTO salida = new SistEstrategicoDTO();
            salida.setServStatus(-1);
            salida.setMsgStatus(e.getMessage());
            return ResponseEntity.ok().body(salida);
        }
    }
}
