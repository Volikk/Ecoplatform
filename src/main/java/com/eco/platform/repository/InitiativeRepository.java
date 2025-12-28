package com.eco.platform.repository;

import com.eco.platform.model.Initiative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InitiativeRepository extends JpaRepository<Initiative, Long> {
}
