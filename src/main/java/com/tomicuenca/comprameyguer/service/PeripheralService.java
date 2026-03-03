package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import org.springframework.stereotype.Service;

@Service
public class PeripheralService {

    public KeyboardDTO getTestKeyboard(){
        return KeyboardDTO.builder()
                .model("Asus COOL Keyboard")
                .imported(true)
                .price("150.00 USD")
                .weight(0.6)
                .stock(10)
                .keys(55)
                .mechanical(true)
                .build();
    }
}
