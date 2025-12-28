package com.eco.platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class EcoProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;
    private String imageUrl;

    private String city;
    private Double lat;
    private Double lng;

    private Double goalAmount;
    private Double currentAmount = 0.0;
    private String status;

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}