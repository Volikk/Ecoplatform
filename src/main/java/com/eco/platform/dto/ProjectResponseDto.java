package com.eco.platform.dto;

import java.util.List;

public class ProjectResponseDto {
    private Long id;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private String imageUrl;
    private String category;
    private String city;
    private Double goalAmount;
    private Double currentAmount;
    private String status;
    private List<GoalDto> goals;
    private Integer volunteersNeeded;
    private Integer volunteersActive;
    private Double progress;
    private String readyToHelpTitle;
    private String readyToHelpDescription;

    public ProjectResponseDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getFullDescription() { return fullDescription; }
    public void setFullDescription(String fullDescription) { this.fullDescription = fullDescription; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Double getGoalAmount() { return goalAmount; }
    public void setGoalAmount(Double goalAmount) { this.goalAmount = goalAmount; }

    public Double getCurrentAmount() { return currentAmount; }
    public void setCurrentAmount(Double currentAmount) { this.currentAmount = currentAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<GoalDto> getGoals() { return goals; }
    public void setGoals(List<GoalDto> goals) { this.goals = goals; }

    public String getReadyToHelpTitle() { return readyToHelpTitle; }
    public void setReadyToHelpTitle(String readyToHelpTitle) { this.readyToHelpTitle = readyToHelpTitle; }

    public String getReadyToHelpDescription() { return readyToHelpDescription; }
    public void setReadyToHelpDescription(String readyToHelpDescription) { this.readyToHelpDescription = readyToHelpDescription; }

    public Integer getVolunteersNeeded() { return volunteersNeeded; }
    public void setVolunteersNeeded(Integer volunteersNeeded) { this.volunteersNeeded = volunteersNeeded; }

    public Integer getVolunteersActive() { return volunteersActive; }
    public void setVolunteersActive(Integer volunteersActive) { this.volunteersActive = volunteersActive; }

    public Double getProgress() { return progress; }
    public void setProgress(Double progress) { this.progress = progress; }
}
