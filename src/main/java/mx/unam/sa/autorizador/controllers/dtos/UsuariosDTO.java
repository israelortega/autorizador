/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.controllers.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author israel1971
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsuariosDTO {
    Integer numEmp;
    String nombre;
    String primerApp;
    String segundoApp;
}
