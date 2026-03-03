package com.tomicuenca.comprameyguer.controller;

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
}
