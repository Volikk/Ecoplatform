package com.eco.platform.config;

import com.eco.platform.model.Donation;
import com.eco.platform.model.EcoProject;
import com.eco.platform.model.User;
import com.eco.platform.repository.DonationRepository;
import com.eco.platform.repository.UserRepository;
import com.eco.platform.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   ProjectRepository projectRepository,
                                   DonationRepository donationRepository,
                                   PasswordEncoder encoder) {
        return args -> {
            // 1. Створення користувача
            if (userRepository.count() == 0) {
                User user = new User();
                user.setName("Володимир");
                user.setEmail("test@eco.com");
                user.setPassword(encoder.encode("password"));
                user.setRole("USER");
                user.setAvatarUrl("https://placehold.co/200");
                userRepository.save(user);
            }

            // 2. Створення проєктів
            if (projectRepository.count() == 0) {
                EcoProject p1 = new EcoProject();
                p1.setTitle("Очищення Дніпра");
                p1.setShortDescription("Масштабна акція з очищення берегової лінії від пластику та скла.");
                p1.setCategory("Екологія");
                p1.setCity("Київ");
                p1.setImageUrl("https://picsum.photos/id/101/400/300");
                p1.setGoalAmount(50000.0);
                p1.setCurrentAmount(12500.0);
                p1.setStatus("ACTIVE");
                projectRepository.save(p1);

                EcoProject p2 = new EcoProject();
                p2.setTitle("Притулок 'Лапа'");
                p2.setShortDescription("Збір коштів на закупівлю зимових вольєрів та корму для тварин.");
                p2.setCategory("Тварини");
                p2.setCity("Львів");
                p2.setImageUrl("https://picsum.photos/id/102/400/300");
                p2.setGoalAmount(30000.0);
                p2.setCurrentAmount(28000.0);
                p2.setStatus("ACTIVE");
                projectRepository.save(p2);

                EcoProject p3 = new EcoProject();
                p3.setTitle("Еко-лекторій");
                p3.setShortDescription("Курс лекцій для школярів про сортування сміття.");
                p3.setCategory("Освіта");
                p3.setCity("Одеса");
                p3.setImageUrl("https://picsum.photos/id/103/400/300");
                p3.setGoalAmount(10000.0);
                p3.setCurrentAmount(10000.0);
                p3.setStatus("COMPLETED");
                projectRepository.save(p3);

                EcoProject p4 = new EcoProject();
                p4.setTitle("Інклюзивний майданчик");
                p4.setShortDescription("Створення безпечного простору для ігор дітей з інвалідністю.");
                p4.setCategory("Соціум");
                p4.setCity("Харків");
                p4.setImageUrl("https://picsum.photos/id/104/400/300");
                p4.setGoalAmount(150000.0);
                p4.setCurrentAmount(45000.0);
                p4.setStatus("ACTIVE");
                projectRepository.save(p4);

                EcoProject p5 = new EcoProject();
                p5.setTitle("Продуктові набори");
                p5.setShortDescription("Допомога літнім людям, що опинилися у скрутному становищі.");
                p5.setCategory("Гуманітарна допомога");
                p5.setCity("Київ");
                p5.setImageUrl("https://picsum.photos/id/105/400/300");
                p5.setGoalAmount(20000.0);
                p5.setCurrentAmount(500.0);
                p5.setStatus("ACTIVE");
                projectRepository.save(p5);

                System.out.println("✅ База заповнена: 5 проєктів додано");
            }

            // 3. Створення донату (виконується після того, як юзери та проєкти вже існують)
            if (donationRepository.count() == 0) {
                User testUser = userRepository.findAll().get(0);
                EcoProject testProject = projectRepository.findAll().get(0);

                Donation donation = new Donation();
                donation.setAmount(500.0);
                donation.setUser(testUser);
                donation.setProject(testProject);
                donation.setCreatedAt(LocalDateTime.now());

                donationRepository.save(donation);
                System.out.println("✅ Тестовий донат додано!");
            }

            System.out.println("-----------------------------------------");
            System.out.println("🚀 СЕРВЕР ЗАПУЩЕНО");
            System.out.println("Логін: test@eco.com | Пароль: password");
            System.out.println("-----------------------------------------");
        };
    }
}