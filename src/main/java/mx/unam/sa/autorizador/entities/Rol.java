/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author israel1971
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CROL")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "iIdRol")
    Integer idRol;
    @Column(name = "vcNomRol", length = 50)
    String rol;
    @Column(name = "vcDesRol", length = 50)
    String descripcion;
    @Column(name = "cTipRol", columnDefinition = "CHAR (3)")
    String tipo;
    @Column(name = "vcIpReg", length = 16, nullable = false)
    String ipReg;
    @Column(name = "vcRfcReg", length = 13, nullable = false)
    String rfcReg;
    @Column(name = "dtFecReg", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date fecReg = new Date();
    @Column(name = "siStatus", nullable = false)
    int status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSistema", nullable = false)
    private SistEstrategico sistema;

    public Rol(Integer idRol, String rol, String descripcion, String tipo,
            String ipReg, String rfcReg, SistEstrategico sistema) {
        this.idRol = idRol;
        this.rol = rol;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.ipReg = ipReg;
        this.rfcReg = rfcReg;
        this.status = 1;
        this.sistema = sistema;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + ", rol=" + rol + ", " +
                "descripcion=" + descripcion + ", tipo=" + tipo + ", "
                + "ipReg=" + ipReg + ", rfcReg=" + rfcReg + ", "
                + "fecReg=" + fecReg + ", status=" + status + '}';
    }

}
