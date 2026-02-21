package com.eco.platform.repository;

import com.eco.platform.model.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
}
