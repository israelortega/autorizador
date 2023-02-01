/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.repository;

import mx.unam.sa.autorizador.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author israel1971
 */
@SpringBootTest
public class UsuarioRepoTest {

    Logger logger = LoggerFactory.getLogger(UsuarioRepoTest.class);

    @Autowired
    UsuarioRepo usuRepo;

    @Test
    void testFindAllPage() {

        logger.info("\u001B[32m" + "------------testFindAllPage" + "\u001B[0m");

        Pageable pageable = PageRequest.of(0, 4);
        Page<Usuario> usuarios = usuRepo.findAll(pageable);

        for (Usuario usuario : usuarios.getContent()) {
            logger.info(usuario.toString());
        }

        logger.info("segunda página");

        Pageable pageable2 = PageRequest.of(1, 4);
        Page<Usuario> usuarios2 = usuRepo.findAll(pageable2);

        for (Usuario usuario : usuarios2.getContent()) {
            logger.info(usuario.toString());
        }

        logger.info("tercera página");

        Pageable pageable3 = PageRequest.of(2, 4);
        Page<Usuario> usuarios3 = usuRepo.findAll(pageable3);

        for (Usuario usuario : usuarios3.getContent()) {
            logger.info(usuario.toString());
        }

    }
}
