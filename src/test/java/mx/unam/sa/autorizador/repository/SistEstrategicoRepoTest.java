/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.repository;

import java.util.Optional;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author israel1971
 */
@SpringBootTest
public class SistEstrategicoRepoTest {

    Logger logger = LoggerFactory.getLogger(SistEstrategicoRepoTest.class);
    
    @Autowired
    SistEstrategicoRepo sistEstrategicoRepo;

    @Test
    void testFindByID() {
        logger.info("------------testFindByID");
        Optional<SistEstrategico> sistemaOpt = sistEstrategicoRepo.findById(1);

        if (sistemaOpt.isPresent()) {
            logger.info(sistemaOpt.get().getRoles().toString());
        }
    }

}
