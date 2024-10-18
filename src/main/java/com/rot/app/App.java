package com.rot.app;

import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner runner(CategoryRepository categoryRepository) {
        return args -> {
            System.out.println("Try to save category");
            for (String name : Arrays.asList("Category 1", "Category 2", "Category 3")) {
                Category category = new Category(name);
                categoryRepository.save(category);
            }

        };
    }
}
