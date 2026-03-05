package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.service.KeyboardService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keyboard")
@RequiredArgsConstructor
public class KeyboardController {

    private final KeyboardService keyboardService;

    @GetMapping()
    public KeyboardDTO getKeyboard(@RequestParam Long id){
        return keyboardService.getKeyboard(id);
    }

    @GetMapping("/all")
    public List<String> getAllKeyboardModels(){
        return keyboardService.getAllKeyboardModels();
    }

    @PostMapping("/save")
    public String saveKeyboard(@RequestBody KeyboardInputDTO input){
        return keyboardService.saveKeyboard(input);
    }

    @PatchMapping("/sell")
    public String sellKeyboard(@RequestParam Long id){
        return keyboardService.sellKeyboard(id);
    }


}
