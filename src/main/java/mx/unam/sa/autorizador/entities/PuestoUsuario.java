/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "TRUSU_PUE", uniqueConstraints = { @UniqueConstraint(columnNames = { "iNumEmp", "idPuesto"}) })
public class PuestoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "iNumEmp")
    Integer numEmp;
    @Column(name = "idPuesto")
    Integer idPuesto;

    
    
}
