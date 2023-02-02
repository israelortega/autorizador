/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.sa.autorizador.controllers;

import mx.unam.sa.autorizador.controllers.dtos.AreasDTO;
import mx.unam.sa.autorizador.services.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author unam
 */
@Controller
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    AreasService areaService;

    @GetMapping("/getAreasBySubsitema/{valor1}")
    public ResponseEntity<AreasDTO> getAreasBySubsitema(@PathVariable("valor1") Integer valor1) {
        AreasDTO salida = new AreasDTO();
        try {
            salida.setAreas(areaService.getAreasBySubsistema(Short.parseShort(valor1 + "")));
            salida.setStatusSrv(1);
            salida.setMsgStatus("Exito");
        } catch (Exception e) {
            salida.setStatusSrv(0);
            salida.setMsgStatus(e.toString());
            return ResponseEntity.ok().body(salida);
        }

        return ResponseEntity.ok().body(salida);
    }

}
