/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import java.util.Date;
import java.util.Set;
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
@Entity
@NoArgsConstructor
@ToString
@Table(name = "CSISTESTRATEGICO")
public class SistEstrategico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSistema")
    Integer idSistema;
    @Column(name = "vcNombreSist", length = 50, nullable = false)
    String sistema;
    @Column(name = "vcDescripcion", length = 255)
    String descripcion;
    @Column(name = "vcUrl", length = 16)
    String url;
    @Column(name = "dtFecInicio")
    @Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
    Date fechaInicio;
    @Column(name = "dtFecFin")
    @Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
    Date fechaFin;
    @Column(name = "siStatus", nullable = false)
    Short status;
    @Column(name = "vcIpReg", length = 16, nullable = false)
    String ipReg;
    @Column(name = "vcRfcReg", length = 13, nullable = false)
    String rfcReg;
    @Column(name = "dtFecReg", nullable = false)
    @Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
    Date fecReg = new Date();

    @OneToMany(mappedBy = "sistema", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Rol> roles;

    public void addRol(Rol rol) {
        roles.add(rol);
        rol.setSistema(this);
    }

    public void removeRol(Rol rol) {
        roles.remove(rol);
        rol.setSistema(null);
    }

    public SistEstrategico(Integer idSistema, String sistema, String descripcion,
            String url, Date fechaInicio, Date fechaFin, String ipReg, String rfcReg) {
        this.idSistema = idSistema;
        this.sistema = sistema;
        this.descripcion = descripcion;
        this.url = url;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.status = 1;
        this.ipReg = ipReg;
        this.rfcReg = rfcReg;
    }

    public SistEstrategico(String sistema, String descripcion, String url,
            Date fechaInicio, Date fechaFin, String ipReg, String rfcReg) {
        this.sistema = sistema;
        this.descripcion = descripcion;
        this.url = url;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.status = 1;
        this.ipReg = ipReg;
        this.rfcReg = rfcReg;
    }
}
