package com.tomicuenca.comprameyguer.controller;

import com.tomicuenca.comprameyguer.dto.input.MonitorInputDTO;
import com.tomicuenca.comprameyguer.dto.output.MonitorOutputDTO;
import com.tomicuenca.comprameyguer.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitor")
@RequiredArgsConstructor
public class MonitorController {

    private final MonitorService monitorService;

    @GetMapping()
    public MonitorOutputDTO getMonitor(@RequestParam Long id) {
        return monitorService.getItem(id);
    }

    @GetMapping("/localCurrency")
    public MonitorOutputDTO getMonitorInLocalCurrency(@RequestParam Long id) {
        return monitorService.getItemInLocalCurrency(id);
    }

    @GetMapping("/models")
    public List<String> getAllMonitorModels() {
        return monitorService.getAllItemModels();
    }

    @PostMapping()
    public String saveMonitor(@RequestBody MonitorInputDTO input) {
        return monitorService.saveItem(input);
    }

    @PatchMapping("/sell")
    public String sellMonitor(@RequestParam Long id) {
        return monitorService.sellItem(id);
    }

    @PatchMapping("/update")
    public String updateMonitor(@RequestParam Long id, @RequestBody MonitorInputDTO input) {
        return monitorService.updateItem(id, input);
    }

    @DeleteMapping()
    public String deleteMonitor(@RequestParam Long id) {
        return monitorService.deleteItem(id);
    }


}
