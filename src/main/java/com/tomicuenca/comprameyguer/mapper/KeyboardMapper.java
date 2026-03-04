package com.tomicuenca.comprameyguer.mapper;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import com.tomicuenca.comprameyguer.enums.CurrencyEnum;

public class KeyboardMapper {


    public static KeyboardDTO entityToDTO(KeyboardEntity entity){

        CurrencyEnum currency;
        if(!entity.getImported()){
            currency = CurrencyEnum.ARS;
        }
        else{
            currency = CurrencyEnum.USD;
        }

        return KeyboardDTO.builder()
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

    public static KeyboardEntity inputDTOToEntity(KeyboardInputDTO input){
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
}
