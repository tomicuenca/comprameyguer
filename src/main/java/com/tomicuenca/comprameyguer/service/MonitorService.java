package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.input.MonitorInputDTO;
import com.tomicuenca.comprameyguer.dto.output.MonitorOutputDTO;
import com.tomicuenca.comprameyguer.entity.MonitorEntity;
import com.tomicuenca.comprameyguer.mapper.MonitorMapper;
import com.tomicuenca.comprameyguer.repository.MonitorRepository;
import com.tomicuenca.comprameyguer.service.external.ConversionRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MonitorService extends PeripheralService<MonitorEntity, MonitorInputDTO, MonitorOutputDTO> {

    public MonitorService(MonitorRepository repository, ConversionRateService conversionRateService) {
        super(repository, conversionRateService);
    }

    @Override
    protected MonitorOutputDTO entityToOutputDTO(MonitorEntity entity) {
        return MonitorMapper.entityToOutputDTO(entity);
    }

    @Override
    protected MonitorEntity inputDTOToEntity(MonitorInputDTO input) {
        return MonitorMapper.inputDTOToEntity(input);
    }

    @Override
    protected MonitorEntity partialInputDTOToEntity(MonitorInputDTO input, MonitorEntity entity) {
        return MonitorMapper.partialInputDTOToEntity(input, entity);
    }
}
