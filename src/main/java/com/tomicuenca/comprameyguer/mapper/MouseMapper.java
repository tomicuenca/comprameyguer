package com.tomicuenca.comprameyguer.mapper;

import com.tomicuenca.comprameyguer.dto.input.MouseInputDTO;
import com.tomicuenca.comprameyguer.dto.output.MouseOutputDTO;
import com.tomicuenca.comprameyguer.entity.MouseEntity;
import com.tomicuenca.comprameyguer.enums.CurrencyEnum;

public class MouseMapper {

    public static MouseOutputDTO entityToOutputDTO(MouseEntity entity) {

        CurrencyEnum currency;
        if (!entity.getImported()) {
            currency = CurrencyEnum.ARS;
        } else {
            currency = CurrencyEnum.USD;
        }

        return MouseOutputDTO.builder()
                .model(entity.getModel())
                .imported(entity.getImported())
                .price(entity.getPrice())
                .currency(currency)
                .weight(entity.getWeight())
                .stock(entity.getStock())
                .buttons(entity.getButtons())
                .dpi(entity.getDpi())
                .build();
    }

    public static MouseEntity inputDTOToEntity(MouseInputDTO input) {
        return MouseEntity.builder()
                .model(input.getModel())
                .imported(input.getImported())
                .price(input.getPrice())
                .weight(input.getWeight())
                .stock(input.getStock())
                .buttons(input.getButtons())
                .dpi(input.getDpi())
                .build();
    }

    public static MouseEntity partialInputDTOToEntity(MouseInputDTO input, MouseEntity entity) {
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
        if (input.getButtons() != null) {
            entity.setButtons(input.getButtons());
        }
        if (input.getDpi() != null) {
            entity.setDpi(input.getDpi());
        }
        return entity;
    }

}
