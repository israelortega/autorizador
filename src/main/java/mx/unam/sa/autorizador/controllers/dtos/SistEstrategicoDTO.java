/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author israel1971
 */
@Getter
@Setter
@ToString
public class SistEstrategicoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idSistema;
    String sistema;
    String descripcion;
    String url;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date fechaInicio;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern="yyyy-MM-dd")
    Date fechaFin;
    Short status;
    private Set<RolDTO> roles;
    //Datos de salida del servicio web
    int servStatus;
    String msgStatus;
}
