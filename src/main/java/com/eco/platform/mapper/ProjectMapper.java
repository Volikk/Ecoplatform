package com.eco.platform.mapper;

import com.eco.platform.dto.ProjectResponseDto;
import com.eco.platform.model.EcoProject;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectResponseDto toDto(EcoProject project) {
        ProjectResponseDto dto = new ProjectResponseDto();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setShortDescription(project.getShortDescription());
        dto.setFullDescription(project.getFullDescription());
        dto.setImageUrl(project.getImageUrl());
        dto.setCategory(project.getCategory());
        dto.setCity(project.getCity());
        dto.setGoalAmount(project.getGoalAmount());
        dto.setCurrentAmount(project.getCurrentAmount());
        dto.setStatus(project.getStatus());
        dto.setGoals(project.getGoals());
        dto.setVolunteersNeeded(project.getVolunteersNeeded());
        dto.setVolunteersActive(project.getVolunteersActive());

        if (project.getGoalAmount() != null && project.getGoalAmount() > 0) {
            double percentage = (project.getCurrentAmount() / project.getGoalAmount()) * 100;
            dto.setProgress(Math.round(percentage * 10.0) / 10.0);
        } else {
            dto.setProgress(0.0);
        }

        return dto;
    }
}
