package com.eco.platform.config;

import com.eco.platform.model.EcoProject;
import com.eco.platform.model.User;
import com.eco.platform.repository.UserRepository;
import com.eco.platform.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, ProjectRepository projectRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User user = new User();
                user.setName("Володимир");
                user.setEmail("test@eco.com");
                user.setPassword(passwordEncoder().encode("password"));
                user.setRole("USER");
                user.setAvatarUrl("https://placehold.co/200");
                userRepository.save(user);
            }

            if (projectRepository.count() == 0) {
                EcoProject project = new EcoProject();
                project.setTitle("Очищення парку");
                project.setShortDescription("Збираємо волонтерів для прибирання сміття");
                project.setCategory("Екологія");
                project.setImageUrl("https://picsum.photos/400/300");
                project.setCity("Київ");
                project.setGoalAmount(10000.0);
                project.setCurrentAmount(1500.0);
                project.setStatus("ACTIVE");

                projectRepository.save(project);
            }

            System.out.println("-----------------------------------------");
            System.out.println("✅ БАЗА ДАНИХ ГОТОВА ТА ЗАПОВНЕНА!");
            System.out.println("Логін: test@eco.com | Пароль: password");
            System.out.println("-----------------------------------------");
        };
    }
}