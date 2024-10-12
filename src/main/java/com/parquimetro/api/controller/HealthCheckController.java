package com.parquimetro.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("\nPARQUIMETRO-API: Rodando\n");
    }

}