package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.service.KeyboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public String testKeyboard(@RequestBody KeyboardInputDTO input){
        return keyboardService.saveKeyboard(input);
    }
}
