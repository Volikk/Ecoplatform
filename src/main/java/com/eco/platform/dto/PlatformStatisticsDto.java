package com.eco.platform.dto;

public class PlatformStatisticsDto {
    private Long totalProjects;
    private Double totalMoneyRaised;
    private Integer totalVolunteers;

    public Integer getCompletedProjects() {
        return completedProjects;
    }

    public void setCompletedProjects(Integer completedProjects) {
        this.completedProjects = completedProjects;
    }

    private Integer completedProjects;

    public Long getTotalProjects() {
        return totalProjects;
    }

    public void setTotalProjects(Long totalProjects) {
        this.totalProjects = totalProjects;
    }

    public Double getTotalMoneyRaised() {
        return totalMoneyRaised;
    }

    public void setTotalMoneyRaised(Double totalMoneyRaised) {
        this.totalMoneyRaised = totalMoneyRaised;
    }

    public Integer getTotalVolunteers() {
        return totalVolunteers;
    }

    public void setTotalVolunteers(Integer totalVolunteers) {
        this.totalVolunteers = totalVolunteers;
    }
}
