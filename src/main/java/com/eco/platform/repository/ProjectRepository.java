package com.eco.platform.repository;

import com.eco.platform.model.EcoProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<EcoProject, Long> {

}