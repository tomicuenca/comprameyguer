package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import com.tomicuenca.comprameyguer.service.KeyboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peripheral")
@RequiredArgsConstructor
public class KeyboardController {

    private final KeyboardService keyboardService;

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/testKeyboard")
    public KeyboardDTO testKeyboard(){
        return keyboardService.getTestKeyboard();
    }
}
