package com.tomicuenca.comprameyguer.mapper;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
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
}
