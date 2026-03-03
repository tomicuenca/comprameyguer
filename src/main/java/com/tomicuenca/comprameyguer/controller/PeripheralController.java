package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peripheral")
public class PeripheralController {

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/testKeyboard")
    public KeyboardDTO testKeyboard(){
        return KeyboardDTO.builder()
                .model("Asus COOL Keyboard")
                .imported(true)
                .price("150 USD")
                .weight(0.6)
                .stock(10)
                .keys(55)
                .mechanical(true)
                .build();
    }
}
