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

        String seed = "project-" + project.getId();
        dto.setImageDesktop("https://picsum.photos/seed/" + seed + "/1400/800");
        dto.setImageTablet("https://picsum.photos/seed/" + seed + "/800/600");
        dto.setImageMobile("https://picsum.photos/seed/" + seed + "/400/300");

        dto.setCategory(project.getCategory());
        dto.setCity(project.getCity());
        dto.setGoalAmount(project.getGoalAmount());
        dto.setCurrentAmount(project.getCurrentAmount());
        dto.setStatus(project.getStatus() != null ? project.getStatus().name() : "PENDING");
        dto.setVolunteersNeeded(project.getVolunteersNeeded() != null ? project.getVolunteersNeeded() : 0);
        dto.setVolunteersActive(project.getVolunteersActive() != null ? project.getVolunteersActive() : 0);
        dto.setGoalAmount(project.getGoalAmount() != null ? project.getGoalAmount() : 0.0);

        dto.setGoals(List.of(
                new GoalDto("Залучити громаду", "Організація волонтерських груп та розповсюдження інформації."),
                new GoalDto("Зібрати кошти", "Закупівля необхідного обладнання та матеріалів для реалізації."),
                new GoalDto("Реалізувати план", "Безпосереднє виконання робіт згідно з екологічними стандартами.")
        ));

        dto.setReadyToHelpTitle("Готовий допомогти?");
        dto.setReadyToHelpDescription("Твоя участь — це реальний крок до чистого довкілля. Приєднуйся до нас!");

        return dto;
    }
}
