/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.services;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import mx.unam.sa.autorizador.repository.SistEstrategicoRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author israel1971
 */
@SpringBootTest
public class SistemasServiceTest {

    Logger logger = LoggerFactory.getLogger(SistemasServiceTest.class);

    @Mock
    private SistEstrategicoRepo sistEstrategicoRepo;

    @InjectMocks
    SistemasService sistemasServ;

    List<SistEstrategico> sistemas;

    @BeforeEach
    void setup() {
        logger.info("Se ejecuta antes de cada test");
    }

    public SistemasServiceTest() {
        logger.info("Se ejecuta una vez por clase");
        try {

            sistemas = List.of(
                    new SistEstrategico(1, "Sistema 1x", "Sistema SA", "", new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"), new SimpleDateFormat("dd-MM-yyyy").parse("31-12-2023"), "127.0.0.1", "808093"),
                    new SistEstrategico(2, "Sistema 2x", "Sistema de DGPe", "", null, null, "127.0.0.1", "808093"),
                    new SistEstrategico("Sistema ?x", "Sitema de Obras", "", null, null, "127.0.0.1", "808093"),
                    new SistEstrategico("Sistema 4x", "Sitema de Presupuesto", "", null, null, "127.0.0.1", "808093"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testGetAll() throws Exception {
        logger.info("\u001B[32m" + "------------testGetAll" + "\u001B[0m");

        Mockito.when(sistEstrategicoRepo.findAll()).thenAnswer(
                invocation -> {
                    return sistemas;
                });

        System.out.println(sistemasServ.getAll());
    }

    @Test
    public void testGetDatosSistema() throws Exception {
        logger.info("\u001B[32m" + "------------testFindByID" + "\u001B[0m");

        Mockito.when(sistEstrategicoRepo.findById(anyInt())).thenAnswer(
                invocation -> {
                    Object[] args = invocation.getArguments();

                    Optional<SistEstrategico> sistEstrategico = sistemas.stream()
                            .filter(p -> Objects.equals(p.getIdSistema(), args[0]))
                            .findFirst();

                    return sistEstrategico;

                });

        System.out.println(sistemasServ.getDatosSistema(1).toString());
    }

}
