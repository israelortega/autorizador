/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.autorizador.services;

import java.util.Optional;
import mx.unam.sa.autorizador.controllers.dtos.SistEstrategicoDTO;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import mx.unam.sa.autorizador.repository.SistEstrategicoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author israel1971
 */
@Service
public class SistemasService {
    @Autowired
    SistEstrategicoRepo sistEstrategicoRepo;
    
    
    public SistEstrategicoDTO getDatosSistema(Integer idSistema) throws Exception {
        SistEstrategicoDTO salida = new SistEstrategicoDTO();
        
        try {
            Optional<SistEstrategico> sistEstrategico = sistEstrategicoRepo.findById(idSistema);

            if (sistEstrategico.isPresent()) {
                ModelMapper modelMapper = new ModelMapper();
                salida = modelMapper.map(sistEstrategico.get(), SistEstrategicoDTO.class);
                salida.setServStatus(1);
                salida.setMsgStatus("correcto");
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
        
        return salida;
    }
}
