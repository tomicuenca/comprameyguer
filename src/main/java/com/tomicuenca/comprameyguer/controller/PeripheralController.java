package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import com.tomicuenca.comprameyguer.service.PeripheralService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peripheral")
public class PeripheralController {

    private static PeripheralService peripheralService;

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/testKeyboard")
    public KeyboardDTO testKeyboard(){
        return peripheralService.getTestKeyboard();
    }
}
