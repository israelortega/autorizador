package mx.unam.sa.autorizador.repository;

/*
 * (c) UNAM, 2022
 */


import java.util.List;
import mx.unam.sa.autorizador.entities.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author israel1971
 */
@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {
}
