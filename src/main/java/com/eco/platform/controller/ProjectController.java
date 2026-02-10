package com.eco.platform.controller;

import com.eco.platform.dto.PlatformStatsDto;
import com.eco.platform.dto.ProjectRequestDto;
import com.eco.platform.dto.ProjectResponseDto;
import com.eco.platform.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResponseDto> getAll() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDto getById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/stats")
    public PlatformStatsDto getStats() {
        return projectService.getPlatformStats();
    }

    @PostMapping
    public ProjectResponseDto create(@RequestBody ProjectRequestDto requestDto) {
        return projectService.createProject(requestDto);
    }
}
