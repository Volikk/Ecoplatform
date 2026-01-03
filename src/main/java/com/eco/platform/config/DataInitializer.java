package com.eco.platform.config;

import com.eco.platform.model.User;
import com.eco.platform.repository.UserRepository;
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
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {

            if (userRepository.count() == 0) {
                User user = new User();
                user.setName("Володимир");
                user.setEmail("test@eco.com");
                user.setPassword(passwordEncoder().encode("password"));
                user.setRole("USER");
                user.setAvatarUrl("https://placehold.co/200");

                userRepository.save(user);
                System.out.println("-----------------------------------------");
                System.out.println("✅ БАЗА ДАНИХ ГОТОВА!");
                System.out.println("Логін: test@eco.com");
                System.out.println("Пароль: password");
                System.out.println("-----------------------------------------");
            }
        };
    }
}
