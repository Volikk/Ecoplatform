package com.eco.platform.repository;

import com.eco.platform.model.EcoProject;
import com.eco.platform.model.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<EcoProject, Long> {

    List<EcoProject> findByStatus(ProjectStatus status);

    List<EcoProject> findByStatusIn(List<ProjectStatus> statuses);
}