/*
 * (c) UNAM, 2022
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
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
@NoArgsConstructor
@Embeddable
@ToString
public class AreaId implements Serializable {
     private static final long serialVersionUID = 141220222;

    @Column(name = "siCveDep")
    int cveDep;
    @Column(name = "tiCveSubDep")
    int cveSubDep;
    @Column(name = "siCveArea")
    int cveArea;
   
    public AreaId(int cveDep, int cveSubDep, int cveArea) {
        this.cveDep = cveDep;
        this.cveSubDep = cveSubDep;
        this.cveArea = cveArea;
    }

}
