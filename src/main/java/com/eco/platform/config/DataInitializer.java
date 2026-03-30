package com.eco.platform.config;

import com.eco.platform.model.Donation;
import com.eco.platform.model.EcoProject;
import com.eco.platform.model.ProjectStatus;
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
            if (userRepository.count() == 0) {
                User user = new User();
                user.setName("Володимир");
                user.setEmail("test@eco.com");
                user.setPassword(encoder.encode("password"));
                user.setRole("USER");
                user.setAvatarUrl("https://placehold.co/200");
                userRepository.save(user);
            }

            if (projectRepository.count() == 0) {
                String[] titles = {
                        "Очищення Дніпра", "Притулок 'Лапа'", "Еко-лекторій", "Інклюзивний майданчик", "Продуктові набори",
                        "Сонячні панелі для школи", "Відновлення лісу", "Велодоріжки міста", "Зелений дах", "Очищення озер",
                        "Еко-фестиваль", "Сортування в офісі", "Захист бджіл", "Чисте повітря", "Вертикальні сади"
                };

                String[] descriptions = {
                        "Масштабна акція з очищення берегової лінії.", "Збір коштів на закупівлю зимових вольєрів.", "Курс лекцій для школярів.",
                        "Створення безпечного простору для ігор.", "Допомога літнім людям.", "Встановлення автономного живлення.",
                        "Висадка 1000 дубів у передмісті.", "Маркування нових веломаршрутів.", "Створення саду на даху бібліотеки.",
                        "Очищення місцевих водойм від очерету.", "Організація заходу про сталий розвиток.", "Встановлення баків для паперу та пластику.",
                        "Створення безпечних зон для запилювачів.", "Моніторинг якості повітря в районі.", "Озеленення фасадів будинків."
                };

                for (int i = 0; i < titles.length; i++) {
                    EcoProject p = new EcoProject();
                    p.setTitle(titles[i]);
                    p.setShortDescription(descriptions[i]);

                    p.setFullDescription("Це детальний опис проєкту '" + titles[i] + "'. Ми прагнемо змінити світ на краще через локальні еко-ініціативи.");
                    p.setGoals("1. Залучити громаду; 2. Зібрати необхідні кошти; 3. Реалізувати план робіт.");
                    p.setVolunteersNeeded(10 + (i * 3));
                    p.setVolunteersActive(2 + i);

                    p.setCategory(i % 3 == 0 ? "Екологія" : (i % 3 == 1 ? "Соціум" : "Освіта"));
                    p.setCity(i % 2 == 0 ? "Київ" : "Львів");
                    p.setImageUrl("https://picsum.photos/seed/" + i + "/400/300");
                    p.setGoalAmount(10000.0 * (i + 1));
                    p.setCurrentAmount(5000.0 * i);
                    p.setStatus(i == 2 ? ProjectStatus.COMPLETED : ProjectStatus.ACTIVE);

                    projectRepository.save(p);
                }
                System.out.println("Створенно 15 проектів");
            }

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
