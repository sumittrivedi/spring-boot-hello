package com.example.controller;

import com.example.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/utils")
public class UtilsController {

    private final MathService mathService;

    public UtilsController(MathService mathService) {
        this.mathService = mathService;
    }

    // GET /api/utils/compute?a=12&b=8
    @GetMapping("/compute")
    public ResponseEntity<Map<String, Object>> computeGet(@RequestParam long a, @RequestParam long b) {
        Map<String, Object> payload = mathService.compute(a, b);
        return ResponseEntity.ok(payload);
    }

    // POST /api/utils/compute  with JSON body {"a":12,"b":8}
    @PostMapping("/compute")
    public ResponseEntity<Map<String, Object>> computePost(@RequestBody Map<String, Number> body) {
        long a = body.getOrDefault("a", 0).longValue();
        long b = body.getOrDefault("b", 0).longValue();
        Map<String, Object> payload = mathService.compute(a, b);
        return ResponseEntity.ok(payload);
    }
}
