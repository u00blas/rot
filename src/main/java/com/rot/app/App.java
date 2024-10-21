package com.rot.app;

import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import com.rot.app.contact.Contact;
import com.rot.app.contact.ContactRepository;
import com.rot.app.proposal.Proposal;
import com.rot.app.proposal.ProposalRepository;
import com.rot.app.question.Question;
import com.rot.app.question.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner runner(ContactRepository contactRepository,
                             CategoryRepository categoryRepository,
                             QuestionRepository questionRepository,
                             ProposalRepository proposalRepository) {
        return args -> {

            for (String name : Arrays.asList("Bosch", "Ikea")) {
                Contact contact = new Contact();
                contact.setName(name);
                contact.setEmail("test");
                contact.setPhone("test");
                contact.setComment("test");
                contactRepository.save(contact);
            }

            List<Proposal> proposalList = MigrateData.getProposalsFromCsv();
            for (Proposal proposal : proposalList) {
                proposalRepository.save(proposal);
            }
            Map<String, Proposal> proposalMap = new HashMap<>();
            for (Proposal proposal : proposalList) {
                proposalMap.put(proposal.getMinScale(), proposal);
            }

            List<Category> categorys = MigrateData.getCategoriesFromCsv();
            for (Category category : categorys) {
                categoryRepository.save(category);
            }

            Map<String, Category> categoryMap = new HashMap<>();
            for (Category category : categorys) {
                categoryMap.put(category.getName(), category);
            }
            List<Question> questions = MigrateData.getQuestionsFromCsv();
            List<String[]> questionParts = MigrateData.getQuestionParts();
            int distinctColumnIndex = MigrateData.getColumnIndex("W");
            for (Question question : questions) {
                try {
                    for (String[] part : questionParts) {
                        if (part[distinctColumnIndex].equals(question.getName())) {
                            question.setCategory(categoryMap.get(part[MigrateData.getColumnIndex("D") - 1]));
                            System.out.println("--------------------------------------------- " + part[MigrateData.getColumnIndex("Y")]);
                            question.setProposal(proposalMap.get(part[MigrateData.getColumnIndex("Y")]));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Parts is null");
                }
                try {
                    questionRepository.save(question);
                } catch (Exception e) {
                    System.out.println("Question already exists: " + question);
                }
            }
        };
    }


}