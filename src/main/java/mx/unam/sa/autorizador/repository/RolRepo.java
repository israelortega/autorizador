package mx.unam.sa.autorizador.repository;

/*
 * (c) UNAM, 2022
 */


import java.util.Set;
import mx.unam.sa.autorizador.entities.Rol;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author israel1971
 */
@Repository
public interface RolRepo extends JpaRepository<Rol,Integer> {
    Set<Rol> findBySistema(SistEstrategico sistema);
}
