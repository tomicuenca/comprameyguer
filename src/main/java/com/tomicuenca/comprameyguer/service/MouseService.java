package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.input.MouseInputDTO;
import com.tomicuenca.comprameyguer.dto.output.MouseOutputDTO;
import com.tomicuenca.comprameyguer.entity.MouseEntity;
import com.tomicuenca.comprameyguer.mapper.MouseMapper;
import com.tomicuenca.comprameyguer.repository.MouseRepository;
import com.tomicuenca.comprameyguer.service.external.ConversionRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MouseService extends PeripheralService<MouseEntity, MouseInputDTO, MouseOutputDTO> {

    public MouseService(MouseRepository repository, ConversionRateService conversionRateService) {
        super(repository, conversionRateService);
    }

    @Override
    protected MouseOutputDTO entityToOutputDTO(MouseEntity entity) {
        return MouseMapper.entityToOutputDTO(entity);
    }

    @Override
    protected MouseEntity inputDTOToEntity(MouseInputDTO input) {
        return MouseMapper.inputDTOToEntity(input);
    }

    @Override
    protected MouseEntity partialInputDTOToEntity(MouseInputDTO input, MouseEntity entity) {
        return MouseMapper.partialInputDTOToEntity(input, entity);
    }

}
