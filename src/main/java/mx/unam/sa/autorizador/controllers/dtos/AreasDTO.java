/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.sa.autorizador.controllers.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author unam
 */
@Getter
@Setter
public class AreasDTO {
    
    List<AreaDTO> areas;
    int statusSrv;
    String msgStatus;
    
}
