package org.example.introspr.config;


import org.example.introspr.model.Task;
import org.example.introspr.repository.TaskRepository;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {
        return args -> {
            repository.save(new Task("Купить молоко"));
            repository.save(new Task("Сделать домашку"));
            repository.save(new Task("Позвонить маме"));
            System.out.println("Тестовые данные добавлены!");
        };

    }
}
