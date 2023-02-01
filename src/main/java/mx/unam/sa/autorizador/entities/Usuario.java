/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "TUSUARIO", uniqueConstraints = { @UniqueConstraint(columnNames = { "vcNombre", "vcAp_Pat", "vcAp_Mat" }) })
public class Usuario implements Serializable {
    private static final long serialVersionUID = 202301110L;
    
    @Id
    @Column(name = "iNumEmp")
    Integer numEmp;
    @Column(name = "vcNombre", length=50, nullable = false)
    String nombre;
    @Column(name = "vcAp_Pat", length=50, nullable = false)
    String primerApp;
    @Column(name = "vcAp_Mat", length=50)
    String segundoApp;
    @Column(name = "vcCurpEmp", length=18)
    String curp;
    @Column(name = "vcToken", length=64)
    String token;
    @Column(name = "vcIpReg", length=16, nullable = false)
    String ipReg;
    @Column(name = "vcRfcReg", length=13, nullable = false)
    String rfcReg;
    @Column(name = "vcCorreo", length=200)
    String correo;
    @Column(name = "dtFecReg",  nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date fecReg = new Date();        
    @Column(name = "cDepPrincipal", length=6)
    String depPrincipal;
    @Column(name = "vcUsuarioGI", length=13)        
    String usuarioGI;
    @Column(name = "siStatus", nullable = false)
    Short siStatus;
    
    public Usuario(Integer numEmp, String nombre, String primerApp, String segundoApp, String ipReg, String rfcReg ) {
        this.numEmp = numEmp;
        this.nombre = nombre;
        this.primerApp = primerApp;
        this.segundoApp = segundoApp;
        this.ipReg = ipReg ;
        this.rfcReg = rfcReg;
        this.siStatus = 1;
    }

    public Usuario(Integer numEmp, String nombre, String primerApp, String segundoApp, String curp, String token, String ipReg, String rfcReg, String correo, Date fecReg, String depPrincipal, String usuarioGI, Short siStatus) {
        this.numEmp = numEmp;
        this.nombre = nombre;
        this.primerApp = primerApp;
        this.segundoApp = segundoApp;
        this.curp = curp;
        this.token = token;
        this.ipReg = ipReg;
        this.rfcReg = rfcReg;
        this.correo = correo;
        this.fecReg = fecReg;
        this.depPrincipal = depPrincipal;
        this.usuarioGI = usuarioGI;
        this.siStatus = siStatus;
    }
    
    

}
