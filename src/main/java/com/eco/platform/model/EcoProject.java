package com.eco.platform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class EcoProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;
    private String imageUrl;
    private String city;
    private Double goalAmount;
    private Double currentAmount = 0.0;
    private String category;
    private String contactEmail;
    private String duration;

    @Column(columnDefinition = "TEXT")
    private String fullDescription;

    @Column(columnDefinition = "TEXT")
    private String goals;

    private Integer volunteersNeeded;
    private Integer volunteersActive;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status = ProjectStatus.PENDING;


    public EcoProject() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public String getShortDescription() { return shortDescription; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getImageUrl() { return imageUrl; }

    public void setCity(String city) { this.city = city; }
    public String getCity() { return city; }

    public void setGoalAmount(Double goalAmount) { this.goalAmount = goalAmount; }
    public Double getGoalAmount() { return goalAmount; }

    public void setCurrentAmount(Double currentAmount) { this.currentAmount = currentAmount; }
    public Double getCurrentAmount() { return currentAmount; }

    public ProjectStatus getStatus() { return status; }
    public void setStatus(ProjectStatus status) { this.status = status; }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public Integer getVolunteersNeeded() {
        return volunteersNeeded;
    }

    public void setVolunteersNeeded(Integer volunteersNeeded) {
        this.volunteersNeeded = volunteersNeeded;
    }

    public Integer getVolunteersActive() {
        return volunteersActive;
    }

    public void setVolunteersActive(Integer volunteersActive) {
        this.volunteersActive = volunteersActive;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
