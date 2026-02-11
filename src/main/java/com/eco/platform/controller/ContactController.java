package com.eco.platform.controller;

import com.eco.platform.dto.ContactRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @PostMapping
    public ResponseEntity<String> handleContactForm(@RequestBody ContactRequestDto dto) {
        System.out.println("Нове повідомлення від: " + dto.getName() + " (" + dto.getEmail() + ")");
        return ResponseEntity.ok("Повідомлення отримано!");
    }
}
