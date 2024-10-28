package com.personapi.personapi.adapters.driving.controller;

import com.personapi.personapi.adapters.util.AdaptersConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public ResponseEntity<String> getHealthCheck(){
        return ResponseEntity.ok(AdaptersConstants.HEALTH_CHECK_MESSAGE);
    }
}
