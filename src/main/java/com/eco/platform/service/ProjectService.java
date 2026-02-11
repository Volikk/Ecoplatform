package com.eco.platform.service;

import com.eco.platform.dto.PlatformStatsDto;
import com.eco.platform.dto.ProjectRequestDto;
import com.eco.platform.dto.ProjectResponseDto;
import com.eco.platform.exception.ResourceNotFoundException;
import com.eco.platform.mapper.ProjectMapper;
import com.eco.platform.model.EcoProject;
import com.eco.platform.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public List<ProjectResponseDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProjectResponseDto getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(projectMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Проєкт не знайдено з ID: " + id));
    }

    public PlatformStatsDto getPlatformStats() {
        List<EcoProject> projects = projectRepository.findAll();

        long totalProjects = projects.size();
        double totalMoney = projects.stream().mapToDouble(p -> p.getCurrentAmount() != null ? p.getCurrentAmount() : 0.0).sum();
        int totalVolunteers = projects.stream().mapToInt(p -> p.getVolunteersActive() != null ? p.getVolunteersActive() : 0).sum();
        int ecologyPoints = (int) projects.stream().filter(p -> "COMPLETED".equals(p.getStatus())).count() * 50;

        return new PlatformStatsDto(totalProjects, totalMoney, totalVolunteers, ecologyPoints);
    }

    public ProjectResponseDto createProject(ProjectRequestDto dto) {
        EcoProject project = new EcoProject();

        project.setTitle(dto.getTitle());
        project.setShortDescription(dto.getShortDescription());
        project.setGoals(dto.getGoals());
        project.setCategory(dto.getCategory());
        project.setContactEmail(dto.getContactEmail());
        project.setDuration(dto.getDuration());
        project.setGoalAmount(dto.getGoalAmount());
        project.setImageUrl(dto.getImageUrl());

        project.setCurrentAmount(0.0);
        project.setVolunteersActive(0);
        project.setVolunteersNeeded(0);
        project.setStatus("ACTIVE");
        project.setFullDescription(dto.getShortDescription());
        project.setCity("Не вказано");

        EcoProject savedProject = projectRepository.save(project);
        return projectMapper.toDto(savedProject);
    }
}
