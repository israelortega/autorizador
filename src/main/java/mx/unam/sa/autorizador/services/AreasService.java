/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.sa.autorizador.services;

import java.util.List;
import java.util.stream.Collectors;
import mx.unam.sa.autorizador.controllers.dtos.AreaDTO;
import mx.unam.sa.autorizador.controllers.dtos.AreaIdDTO;
import mx.unam.sa.autorizador.entities.Area;
import mx.unam.sa.autorizador.repository.AreaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author unam
 */
@Service
public class AreasService {

    @Autowired
    AreaRepo areaRepo;

    public List<AreaDTO> getAreasBySubsistema(Short cveSubSist) throws Exception {
        List<AreaDTO> salida = null;

        try {
            List<Area> areas = areaRepo.findBySubsistema(cveSubSist);

            salida = areas.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e);
        }

        return salida;
    }

    private AreaDTO convertToDto(Area area) {
        ModelMapper modelMapper = new ModelMapper();
        AreaIdDTO areaIdDto = modelMapper.map(area.getArea(), AreaIdDTO.class);
        AreaDTO areaDto = modelMapper.map(area, AreaDTO.class);
        areaDto.setArea(areaIdDto);
        return areaDto;
    }

}
