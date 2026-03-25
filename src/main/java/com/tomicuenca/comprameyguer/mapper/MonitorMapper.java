package com.tomicuenca.comprameyguer.mapper;

import com.tomicuenca.comprameyguer.dto.input.MonitorInputDTO;
import com.tomicuenca.comprameyguer.dto.output.MonitorOutputDTO;
import com.tomicuenca.comprameyguer.entity.MonitorEntity;
import com.tomicuenca.comprameyguer.enums.CurrencyEnum;

public class MonitorMapper {

    public static MonitorOutputDTO entityToOutputDTO(MonitorEntity entity) {

        CurrencyEnum currency;
        if (!entity.getImported()) {
            currency = CurrencyEnum.ARS;
        } else {
            currency = CurrencyEnum.USD;
        }

        return MonitorOutputDTO.builder()
                .model(entity.getModel())
                .imported(entity.getImported())
                .price(entity.getPrice())
                .currency(currency)
                .weight(entity.getWeight())
                .stock(entity.getStock())
                .inches(entity.getInches())
                .panel(entity.getPanel())
                .build();
    }

    public static MonitorEntity inputDTOToEntity(MonitorInputDTO input) {
        return MonitorEntity.builder()
                .model(input.getModel())
                .imported(input.getImported())
                .price(input.getPrice())
                .weight(input.getWeight())
                .stock(input.getStock())
                .inches(input.getInches())
                .panel(input.getPanel())
                .build();
    }

    public static MonitorEntity partialInputDTOToEntity(MonitorInputDTO input, MonitorEntity entity) {
        if (input.getModel() != null) {
            entity.setModel(input.getModel());
        }
        if (input.getImported() != null) {
            entity.setImported(input.getImported());
        }
        if (input.getPrice() != null) {
            entity.setPrice(input.getPrice());
        }
        if (input.getWeight() != null) {
            entity.setWeight(input.getWeight());
        }
        if (input.getStock() != null) {
            entity.setStock(input.getStock());
        }
        if (input.getInches() != null) {
            entity.setInches(input.getInches());
        }
        if (input.getPanel() != null) {
            entity.setPanel(input.getPanel());
        }
        return entity;
    }
}
