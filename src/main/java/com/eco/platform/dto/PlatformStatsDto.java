package com.eco.platform.dto;

public class PlatformStatsDto {
    private long totalProjects;
    private double totalMoneyRaised;
    private int totalVolunteers;
    private int ecologyPoints;

    public PlatformStatsDto(long totalProjects, double totalMoneyRaised, int totalVolunteers, int ecologyPoints) {
        this.totalProjects = totalProjects;
        this.totalMoneyRaised = totalMoneyRaised;
        this.totalVolunteers = totalVolunteers;
        this.ecologyPoints = ecologyPoints;
    }

    public long getTotalProjects() {
        return totalProjects;
    }

    public void setTotalProjects(long totalProjects) {
        this.totalProjects = totalProjects;
    }

    public double getTotalMoneyRaised() {
        return totalMoneyRaised;
    }

    public void setTotalMoneyRaised(double totalMoneyRaised) {
        this.totalMoneyRaised = totalMoneyRaised;
    }

    public int getTotalVolunteers() {
        return totalVolunteers;
    }

    public void setTotalVolunteers(int totalVolunteers) {
        this.totalVolunteers = totalVolunteers;
    }

    public int getEcologyPoints() {
        return ecologyPoints;
    }

    public void setEcologyPoints(int ecologyPoints) {
        this.ecologyPoints = ecologyPoints;
    }
}