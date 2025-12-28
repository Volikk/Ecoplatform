package com.eco.platform.controller;

import com.eco.platform.model.Donation;
import com.eco.platform.repository.DonationRepository;
import com.eco.platform.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/me")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserRepository userRepository;
    private final DonationRepository donationRepository;

    public UserController(UserRepository userRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboard() {
        return userRepository.findById(1L).map(user -> {
            List<Donation> donations = donationRepository.findByUserId(user.getId());

            double totalSum = donations.stream()
                    .mapToDouble(d -> d.getAmount())
                    .sum();

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("stats", Map.of(
                    "totalDonated", totalSum,
                    "projectsSupported", donations.size()
            ));

            response.put("recentDonations", donations.stream().map(d -> Map.of(
                    "projectTitle", d.getProject().getTitle(),
                    "amount", d.getAmount(),
                    "date", d.getCreatedAt()
            )).toList());

            return ResponseEntity.ok(response);
        }).orElse(ResponseEntity.notFound().build());
    }
}
