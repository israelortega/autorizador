/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import mx.unam.sa.autorizador.controllers.dtos.RolDTO;
import mx.unam.sa.autorizador.entities.Rol;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
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
    void testFindBySistema() {

        logger.info("\u001B[32m"+"------------testFindBySistema" + "\u001B[0m");
        //Recupera el sistema 1 para realizar la prueba
        Optional<SistEstrategico> sistemaOpt = sistEstrategicoRepo.findById(1);

        if (sistemaOpt.isPresent()) {
            SistEstrategico sistema = sistemaOpt.get();
            Set<Rol> roles = rolRepo.findBySistema(sistema);

            Set<RolDTO> rolesDto = new HashSet<>();

            for (Rol rol : roles) {
                rolesDto.add(new RolDTO(rol.getIdRol(), rol.getRol(), rol.getDescripcion(), rol.getStatus()));
            }

            System.out.println("rolesDTO" + rolesDto);

            ModelMapper modelMapper = new ModelMapper();
            Set<RolDTO> rolesDto2 = roles
                    .stream()
                    .map(rol -> modelMapper.map(rol, RolDTO.class))
                    .collect(Collectors.toSet());

            System.out.println("rolesDTO2" + rolesDto2);

        }

    }

}
