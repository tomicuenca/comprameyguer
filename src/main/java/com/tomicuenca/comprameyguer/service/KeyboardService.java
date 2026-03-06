package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.dto.output.KeyboardOutputDTO;
import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import com.tomicuenca.comprameyguer.mapper.KeyboardMapper;
import com.tomicuenca.comprameyguer.repository.KeyboardRepository;
import com.tomicuenca.comprameyguer.service.external.ConversionRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KeyboardService extends PeripheralService<KeyboardEntity, KeyboardInputDTO, KeyboardOutputDTO>{

    public KeyboardService(KeyboardRepository repository, ConversionRateService conversionRateService){
        super(repository, conversionRateService);
    }

    @Override
    protected KeyboardOutputDTO entityToOutputDTO(KeyboardEntity entity) {
        return KeyboardMapper.entityToOutputDTO(entity);
    }

    @Override
    protected KeyboardEntity inputDTOToEntity(KeyboardInputDTO input) {
        return KeyboardMapper.inputDTOToEntity(input);
    }
}
