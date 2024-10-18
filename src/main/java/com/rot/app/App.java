package com.rot.app;

import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import com.rot.app.question.Question;
import com.rot.app.question.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner runner(CategoryRepository categoryRepository, QuestionRepository questionRepository) {
        return args -> {
            System.out.println("Try to save category");
            List<Category> categoryList = new ArrayList<>();
            for (String name : Arrays.asList("Category 1", "Category 2", "Category 3")) {
                Category category = new Category(name);
                categoryList.add(category);
                categoryRepository.save(category);
            }
            int i = 0;
            for (String name : Arrays.asList("Question 1", "Question 2", "Question 3")) {
                Question question = new Question(name, categoryList.get(i));
                i++;
                questionRepository.save(question);
            }
        };
    }
}