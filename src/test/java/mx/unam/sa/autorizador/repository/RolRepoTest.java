/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.repository;


import java.util.Optional;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author israel1971
 */
@SpringBootTest
public class RolRepoTest {

    Logger logger = LoggerFactory.getLogger(RolRepoTest.class);
    
    @Autowired
    RolRepo rolRepo;

    @Autowired
    SistEstrategicoRepo sistEstrategicoRepo;

    public RolRepoTest() {
    }

    @Test
    public void testFindBySistema() {
        logger.info("----testFindBySistema");
        Optional<SistEstrategico> sistemaOpt = sistEstrategicoRepo.findById(1);

        if (sistemaOpt.isPresent()) {
            SistEstrategico sistema = sistemaOpt.get();
            logger.info(rolRepo.findBySistema(sistema).toString());
        }

    }

}
