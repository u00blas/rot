package com.rot.app;

import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import com.rot.app.company.Company;
import com.rot.app.company.CompanyRepository;
import com.rot.app.contact.Contact;
import com.rot.app.contact.ContactRepository;
import com.rot.app.key.Key;
import com.rot.app.migration.MigrateData;
import com.rot.app.migration.MigrateRawData;
import com.rot.app.migration.MigrationService;
import com.rot.app.migration.raw.RawCsv;
import com.rot.app.migration.raw.RawCsvRepository;
import com.rot.app.person.Person;
import com.rot.app.person.PersonRepository;
import com.rot.app.proposal.Proposal;
import com.rot.app.proposal.ProposalRepository;
import com.rot.app.question.Question;
import com.rot.app.question.QuestionRepository;
import com.rot.app.questionnaire.Questionnaire;
import com.rot.app.questionnaire.QuestionnaireRepository;
import com.rot.app.session.*;
import com.rot.app.subquestioncontainer.SubquestionContainer;
import com.rot.app.subquestioncontainer.SubquestionContainerRepository;
import com.rot.app.surveys.Survey;
import com.rot.app.surveys.SurveyRepository;
import com.rot.app.targetgroup.TargetGroup;
import com.rot.app.user.User;
import com.rot.app.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class App {


    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository,
                             ContactRepository contactRepository,
                             CategoryRepository categoryRepository,
                             QuestionRepository questionRepository,
                             SurveyRepository surveyRepository,
                             ProposalRepository proposalRepository,
                             QuestionnaireRepository questionnaireRepository,
                             SessionRepository sessionRepository,
                             RawCsvRepository rawCsvRepository,
                             MigrationService migrationService,
                             SubquestionContainerRepository subquestionContainerRepository,
                             PersonRepository personRepository,
                             CompanyRepository companyRepository) {
        return args -> {

            List.of("Mercedes", "Audi", "BMW").forEach(s -> {
                Company company = new Company();
                company.setName(s);
                companyRepository.save(company);
            });
            List.of("Hans Meier", "Olaf Huber", "Max Mustermann").forEach(s -> {
                Person person = new Person();
                person.setName(s);
                String[] parts = s.split(" ");
                String f = parts[0];
                String n = parts[1];
                String e = f.toLowerCase() + "." + n.toLowerCase() + "@test.de";
                person.setEmail(e);
                person.setPhone("1234567");
                person.setComment(s + " is cool");
                personRepository.save(person);
            });

            List<Proposal> proposals = migrationService.createProposals();
            List<SubquestionContainer> subquestionContainers = migrationService.createSubquestionContainers();

            List<String> lines = MigrateRawData.getLinesFromCsv();
            for (String line : lines) {
                RawCsv rawCsv = MigrateRawData.createRawCsvFromLine(line);
                rawCsvRepository.save(rawCsv);
            }

            for (String name : Arrays.asList("Meier", "Meyer", "Mustermann")) {
                User user = new User();
                user.setUsername(name);
                user.setPassword(name);
                userRepository.save(user);
            }
            for (String name : Arrays.asList("Bosch", "Ikea")) {
                Contact contact = new Contact();
                contact.setName(name);
                contact.setEmail(name + "@test.de");
                contact.setPhone("1234567");
                contact.setComment(name + " is cool");
                contactRepository.save(contact);
            }



            List<TargetGroup> targetGroups = migrationService.createTargetGroups();

            List<Key> keys = migrationService.createKeys();

            List<Category> categorys = MigrateData.getCategoriesFromCsv();
            for (Category category : categorys) {
                categoryRepository.save(category);
            }

            Map<String, Category> categoryMap = new HashMap<>();
            for (Category category : categorys) {
                categoryMap.put(category.getName(), category);
            }
            List<Question> questions = migrationService.createQuestions();


            List<String[]> questionParts = MigrateData.getQuestionParts();
            int distinctColumnIndex = MigrateData.getColumnIndex("W");
            for (Question question : questions) {
                try {
                    for (String[] part : questionParts) {
                        if (part[distinctColumnIndex].equals(question.getQuestionDe())) {
                            question.setCategory(categoryMap.get(part[MigrateData.getColumnIndex("D") - 1]));
                            SubquestionContainer subquestionContainer = subquestionContainerRepository.findByQuestion(question.getQuestionDe());
                            question.setSubquestionContainer(subquestionContainer);
                        }
                    }
                } catch (Exception e) {
                    // System.out.println("Parts is null");
                }
                try {
                    questionRepository.save(question);
                } catch (Exception e) {
                    System.out.println("Question already exists: " + question);
                }
            }

            List<Questionnaire> questionnaires = migrationService.createQuestionnaires();
            for (Questionnaire questionnaire : questionnaires) {
                try {
                    questionnaire.setQuestions(questionRepository.findAll().subList(0, 3));
                    questionRepository.findById(8L).ifPresent(q -> questionnaire.getQuestions().add(q));
                    questionRepository.findById(48L).ifPresent(q -> questionnaire.getQuestions().add(q));
                    questionnaireRepository.save(questionnaire);
                } catch (Exception e) {
                    System.out.println("Questionnaire already exists: " + questionnaire);
                }
            }

            List<Survey> surveys = migrationService.createSurveys();
            for (Survey survey : surveys) {
                try {
                    survey.setQuestionnaire(questionnaireRepository.findAll().get(0));
                    surveyRepository.save(survey);
                } catch (Exception e) {
                    System.out.println("Survey already exists: " + survey);
                }
            }

            List<Session> sessions = migrationService.createSessions();
            for (int i = 0; i < sessions.size(); i++) {
                Session session = sessions.get(i);
                try {
                    session.setParticipant(personRepository.findAll().get(i));
                    session.setSurvey(surveyRepository.findAll().get(0));
                    sessionRepository.save(session);
                } catch (Exception e) {
                    System.out.println("Session already exists: " + session);
                }
            }

        };


    }


}