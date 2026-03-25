package com.tomicuenca.comprameyguer.mapper;

import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.dto.output.KeyboardOutputDTO;
import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import com.tomicuenca.comprameyguer.enums.CurrencyEnum;

public class KeyboardMapper {


    public static KeyboardOutputDTO entityToOutputDTO(KeyboardEntity entity) {

        CurrencyEnum currency;
        if (!entity.getImported()) {
            currency = CurrencyEnum.ARS;
        } else {
            currency = CurrencyEnum.USD;
        }

        return KeyboardOutputDTO.builder()
                .model(entity.getModel())
                .imported(entity.getImported())
                .price(entity.getPrice())
                .currency(currency)
                .weight(entity.getWeight())
                .stock(entity.getStock())
                .keys(entity.getKeys())
                .mechanical(entity.getMechanical())
                .build();
    }

    public static KeyboardEntity inputDTOToEntity(KeyboardInputDTO input) {
        return KeyboardEntity.builder()
                .model(input.getModel())
                .imported(input.getImported())
                .price(input.getPrice())
                .weight(input.getWeight())
                .stock(input.getStock())
                .keys(input.getKeys())
                .mechanical(input.getMechanical())
                .build();
    }

    public static KeyboardEntity partialInputDTOToEntity(KeyboardInputDTO input, KeyboardEntity keyboardEntity) {
        if (input.getModel() != null) {
            keyboardEntity.setModel(input.getModel());
        }
        if (input.getImported() != null) {
            keyboardEntity.setImported(input.getImported());
        }
        if (input.getPrice() != null) {
            keyboardEntity.setPrice(input.getPrice());
        }
        if (input.getWeight() != null) {
            keyboardEntity.setWeight(input.getWeight());
        }
        if (input.getStock() != null) {
            keyboardEntity.setStock(input.getStock());
        }
        if (input.getKeys() != null) {
            keyboardEntity.setKeys(input.getKeys());
        }
        if (input.getMechanical() != null) {
            keyboardEntity.setMechanical(input.getMechanical());
        }
        return keyboardEntity;
    }
}
