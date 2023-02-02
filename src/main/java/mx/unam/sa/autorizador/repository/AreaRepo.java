/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.repository;

import java.util.List;
import java.util.Set;
import mx.unam.sa.autorizador.entities.Area;
import mx.unam.sa.autorizador.entities.AreaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author israel1971
 */
public interface AreaRepo extends JpaRepository<Area, AreaId> {
    
    @Query("SELECT u FROM Area u WHERE u.subsistema.cveSubSist = ?1")
    List<Area> findBySubsistema(Short cveSubSist);

    Set<Area> findByAreaAndStatus(AreaId areaID, Integer status);

    @Query("SELECT u FROM Area u WHERE u.area.cveDep = ?1")
    Set<Area> findByDependencia(int cveDep);

    @Query(value = "Select CAREA.* FROM CAREA, CPUESTO where "
            + "CAREA.siCveDep = CPUESTO.siCveDep AND "
            + "CAREA.tiCveSubDep = CPUESTO.tiCveSubDep AND "
            + "CAREA.siCveArea = CPUESTO.siCveArea AND "
            + "CPUESTO.cTipoPuesto = 'T' ",
            nativeQuery = true)
    Set<Area> findByTitulares();
}
