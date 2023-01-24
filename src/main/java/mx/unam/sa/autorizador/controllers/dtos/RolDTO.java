/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author israel1971
 */
@Getter
@Setter
public class RolDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idRol;
    String rol;
    String descripcion;
    int status;

}
