package com.eco.platform.controller;

import com.eco.platform.model.Initiative;
import com.eco.platform.repository.InitiativeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/initiatives")
public class InitiativeController {

    private final InitiativeRepository initiativeRepository;

    public InitiativeController(InitiativeRepository initiativeRepository) {
        this.initiativeRepository = initiativeRepository;
    }

    @PostMapping
    public ResponseEntity<Initiative> createInitiative(@RequestBody Initiative initiative) {
        Initiative saved = initiativeRepository.save(initiative);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<Initiative> getAllInitiatives() {
        return initiativeRepository.findAll();
    }
}
