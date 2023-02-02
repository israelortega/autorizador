/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.pruebasH2;

import java.util.List;
import mx.unam.sa.autorizador.repository.AreaRepoTest;
import mx.unam.sa.autorizador.repository.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author israel1971
 */
@DataJpaTest
@ActiveProfiles("testH2")
public class PruebasTest {

    Logger logger = LoggerFactory.getLogger(PruebasTest.class);

    @Autowired
    UsuarioRepo usuarioRepo;

    @Test
    void tesfindAlltH2() {
        logger.info("\u001B[32m"+"------------tesfindAlltH2" + "\u001B[0m");
        List usuario = usuarioRepo.findAll();
        logger.info(usuario.toString());
    }

}
