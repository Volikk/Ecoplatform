package com.eco.platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta. persistence. ManyToOne;
import jakarta. persistence. JoinColumn;
import jakarta. persistence. GenerationType;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private EcoProject project;

    public Double getAmount() {
        return amount;
    }

    public EcoProject getProject() {
        return project;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
