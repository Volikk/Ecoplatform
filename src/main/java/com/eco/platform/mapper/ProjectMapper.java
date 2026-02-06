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
        dto.setImageUrl("https://picsum.photos/seed/" + seed + "/400/300");
        dto.setImageDesktop("https://picsum.photos/seed/" + seed + "/1400/800");
        dto.setImageTablet("https://picsum.photos/seed/" + seed + "/800/600");
        dto.setImageMobile("https://picsum.photos/seed/" + seed + "/400/300");

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

        dto.setReadyToHelpTitle("Готовий допомогти?");
        dto.setReadyToHelpDescription("Твоя участь — це реальний крок до чистого довкілля. Приєднуйся до нас!");

        return dto;
    }
}
