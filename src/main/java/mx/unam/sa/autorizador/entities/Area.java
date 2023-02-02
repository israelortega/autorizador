/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;
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
@Table(name = "CAREA")
public class Area implements Serializable {

    private static final long serialVersionUID = 141220221;

    @EmbeddedId
    AreaId area;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Subsistema subsistema; 
    
    @Column(name = "vcNomArea", length=50, nullable = false)
    String nomArea;
    @Column(name = "vcIpReg", length=16, nullable = false)
    String ipReg;
    @Column(name = "vcRfcReg", length=13, nullable = false)
    String rfcReg;
    @Column(name = "dtFecReg", 
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date fecReg = new Date();  
    @Column(name = "siStatus")
    Short status;

    @OneToMany(mappedBy = "area")
    private Set<Puesto> puestos;

    public void addPuesto(Puesto puesto) {
        puestos.add(puesto);
        puesto.setArea(this);
    }

    public void removePuesto(Puesto puesto) {
        puestos.remove(puesto);
        puesto.setArea(null);
    }

    public Area(AreaId area, Subsistema subsistema, String nomArea, String ipReg, String rfcReg) {
        this.area = area;
        this.nomArea = nomArea;
        this.subsistema = subsistema;
        this.rfcReg = rfcReg;        
        this.ipReg = ipReg;
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Area{" + "area=" + area + ", subsistema=" + subsistema + ", nomArea=" + nomArea + ", ipReg=" + ipReg + ", rfcReg=" + rfcReg + ", fecReg=" + fecReg + ", status=" + status + ", puestos=" + puestos + '}';
    }

    


    
}
