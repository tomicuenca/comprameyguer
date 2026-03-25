package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.input.MouseInputDTO;
import com.tomicuenca.comprameyguer.dto.output.MouseOutputDTO;
import com.tomicuenca.comprameyguer.service.MouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mouse")
@RequiredArgsConstructor
public class MouseController {

    private final MouseService mouseService;

    @GetMapping()
    public MouseOutputDTO getMouse(@RequestParam Long id) {
        return mouseService.getItem(id);
    }

    @GetMapping("/localCurrency")
    public MouseOutputDTO getMouseInLocalCurrency(@RequestParam Long id) {
        return mouseService.getItemInLocalCurrency(id);
    }

    @GetMapping("/models")
    public List<String> getAllMouseModels() {
        return mouseService.getAllItemModels();
    }

    @PostMapping()
    public String saveMouse(@RequestBody MouseInputDTO input) {
        return mouseService.saveItem(input);
    }

    @PatchMapping("/sell")
    public String sellMouse(@RequestParam Long id) {
        return mouseService.sellItem(id);
    }

    @PatchMapping("/update")
    public String updateMouse(@RequestParam Long id, @RequestBody MouseInputDTO input) {
        return mouseService.updateItem(id, input);
    }

    @DeleteMapping()
    public String deleteMouse(@RequestParam Long id) {
        return mouseService.deleteItem(id);
    }

}
