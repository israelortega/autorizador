/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.repository;

import java.util.Optional;
import java.util.Set;
import mx.unam.sa.autorizador.entities.Area;
import mx.unam.sa.autorizador.entities.AreaId;
import static org.junit.jupiter.api.Assertions.fail;

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
public class AreaRepoTest {

    Logger logger = LoggerFactory.getLogger(AreaRepoTest.class);

    @Autowired
    AreaRepo areaRepo;

    @Test
    void testFindByID() {
        logger.info("\u001B[32m"+"------------testFindByID" + "\u001B[0m");

        Optional<Area> area = areaRepo.findById(new AreaId(723, 1, 1));

        if (area.isPresent()) {
            logger.info(area.get().toString());
        } else fail();
    }

    @Test
    void testFindByAreaAndStatus() {
        logger.info("\u001B[32m"+"------------testfindByAreaAndStatus" + "\u001B[0m");
        Set<Area> areas = areaRepo.findByAreaAndStatus(new AreaId(723, 1, 1), 1);
        logger.info(areas.toString());
    }

    @Test
    void testFindByDependencia() {
        logger.info("\u001B[32m"+"------------testFindByDependencia" + "\u001B[0m");
        Set<Area> areas = areaRepo.findByDependencia(723);
        logger.info(areas.toString());
    }

    @Test
    void findByTitulares() {
        logger.info("\u001B[32m"+"------------findByTitulares" + "\u001B[0m");
        Set<Area> areas = areaRepo.findByTitulares();
        logger.info(areas.toString());
    }
}
