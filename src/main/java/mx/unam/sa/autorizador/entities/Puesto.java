/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author israel1971
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CPUESTO")
public class Puesto implements Serializable {

    private static final long serialVersionUID = 202212151L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPuesto")
    Integer idPuesto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "siCveDep", referencedColumnName = "siCveDep", nullable = false)
    @JoinColumn(name = "tiCveSubDep", referencedColumnName = "tiCveSubDep", nullable = false)
    @JoinColumn(name = "siCveArea", referencedColumnName = "siCveArea", nullable = false)
    private Area area;

    @Column(name = "vcDescripcion", length = 30)
    String descripcion;
    @Column(name = "vcObservacion", length = 50)
    String observacion;

    @Column(name = "cTipoPuesto", columnDefinition = "CHAR (3)")
    String tipoPuesto;
    @Column(name = "dtFecInicio")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    Date fecIni;
    @Column(name = "dtFecFin")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    Date fecFin;
    @Column(name = "vcIpReg", length = 16, nullable = false)
    String ipReg;
    @Column(name = "vcRfcReg", length = 13, nullable = false)
    String rfcReg;
    @Column(name = "dtFecReg", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date fecReg = new Date();
    @Column(name = "siStatus", nullable = false)
    Integer status;

    public Puesto(Area area, String descripcion, String observacion, String tipoPuesto, Date fecIni, Date fecFin, String ipReg, String rfcReg) {
        this.area = area;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.tipoPuesto = tipoPuesto;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.ipReg = ipReg;
        this.rfcReg = rfcReg;
        this.status = 1;
    }

    @JoinTable(
            name = "TRUSU_PUE",
            joinColumns = @JoinColumn(name = "idPuesto", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "iNumEmp", nullable = false)
    )
    @ManyToMany(fetch = FetchType.LAZY)
    @MapsId("idPuesto")
    @Fetch(FetchMode.SUBSELECT)
    List<Usuario> Usuario;

}
