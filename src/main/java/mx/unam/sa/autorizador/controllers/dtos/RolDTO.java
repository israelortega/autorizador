/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class RolDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idRol;
    String rol;
    String descripcion;
    int status;

    public RolDTO(Integer idRol, String rol, String descripcion, int status) {
        this.idRol = idRol;
        this.rol = rol;
        this.descripcion = descripcion;
        this.status = status;
    }
    
    

}
