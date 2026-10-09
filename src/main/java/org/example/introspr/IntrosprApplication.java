package org.example.introspr;

import org.example.introspr.model.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.example.introspr.repository.TaskRepository;


@SpringBootApplication
public class IntrosprApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntrosprApplication.class, args);
    }


}

