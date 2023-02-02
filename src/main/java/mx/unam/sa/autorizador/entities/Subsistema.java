/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author unam
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CSUBSISTEMA")
public class Subsistema implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tiCveSubSist",  columnDefinition="tinyInt")
    Short cveSubSist;
    @Column(name = "vcSubSis", length=50, nullable = false)
    String subsitema;
    @Column(name = "vcIpReg", length=16, nullable = false)
    String ipReg;
    @Column(name = "vcRfcReg", length=13, nullable = false)
    String rfcReg;
    @Column(name = "dtFecReg", 
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date fecReg = new Date();  
    @Column(name = "siStatus")
    Short status;

    public Subsistema(Short cveSubSist, String subsitema, String ipReg, String rfcReg) {
        this.cveSubSist = cveSubSist;
        this.subsitema = subsitema;
        this.ipReg = ipReg;
        this.rfcReg = rfcReg;
    }
    
    
    
    
}
