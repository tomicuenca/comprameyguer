package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.dto.output.KeyboardOutputDTO;
import com.tomicuenca.comprameyguer.service.KeyboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keyboard")
@RequiredArgsConstructor
public class KeyboardController {

    private final KeyboardService keyboardService;

    @GetMapping()
    public KeyboardOutputDTO getKeyboard(@RequestParam Long id) {
        return keyboardService.getItem(id);
    }

    @GetMapping("/localCurrency")
    public KeyboardOutputDTO getKeyboardInLocalCurrency(@RequestParam Long id) {
        return keyboardService.getItemInLocalCurrency(id);
    }

    @GetMapping("/models")
    public List<String> getAllKeyboardModels() {
        return keyboardService.getAllItemModels();
    }

    @PostMapping()
    public String saveKeyboard(@RequestBody KeyboardInputDTO input) {
        return keyboardService.saveItem(input);
    }

    @PatchMapping("/sell")
    public String sellKeyboard(@RequestParam Long id) {
        return keyboardService.sellItem(id);
    }

    @DeleteMapping()
    public String deleteKeyboard(@RequestParam Long id) {
        return keyboardService.deleteItem(id);
    }

}
