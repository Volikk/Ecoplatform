package com.eco.platform.mapper;

import com.eco.platform.dto.GoalDto;
import com.eco.platform.dto.ProjectResponseDto;
import com.eco.platform.model.EcoProject;
import org.springframework.stereotype.Component;
import java.util.List;

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
        dto.setVolunteersNeeded(project.getVolunteersNeeded());
        dto.setVolunteersActive(project.getVolunteersActive());

        dto.setGoals(List.of(
                new GoalDto("Залучити громаду", "Організація волонтерських груп та розповсюдження інформації."),
                new GoalDto("Зібрати кошти", "Закупівля необхідного обладнання та матеріалів для реалізації."),
                new GoalDto("Реалізувати план", "Безпосереднє виконання робіт згідно з екологічними стандартами.")
        ));

        // 2. Додаємо мотиваційний блок (Ready to help)
        dto.setReadyToHelpTitle("Готовий допомогти?");
        dto.setReadyToHelpDescription("Твоя участь — це реальний крок до чистого довкілля. Приєднуйся до нас!");

        return dto;
    }
}