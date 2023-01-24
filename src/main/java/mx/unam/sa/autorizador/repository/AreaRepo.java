/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.repository;

import mx.unam.sa.autorizador.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author israel1971
 */
public interface AreaRepo extends JpaRepository<Area,Integer> {
   
}
