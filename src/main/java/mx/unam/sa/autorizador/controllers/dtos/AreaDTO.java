/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.sa.autorizador.controllers.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author unam
 */
@Getter
@Setter
public class AreaDTO {

    AreaIdDTO area;
    SubsistemaDTO subsistema;
    String nomArea;

}
