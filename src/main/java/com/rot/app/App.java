package com.rot.app;

import com.rot.app.answer.Answer;
import com.rot.app.answer.AnswerDto;
import com.rot.app.answer.AnswerRepository;
import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import com.rot.app.contact.Contact;
import com.rot.app.contact.ContactRepository;
import com.rot.app.proposal.Proposal;
import com.rot.app.proposal.ProposalRepository;
import com.rot.app.question.Question;
import com.rot.app.question.QuestionRepository;
import com.rot.app.questionnaire.Questionnaire;
import com.rot.app.questionnaire.QuestionnaireRepository;
import com.rot.app.surveys.Survey;
import com.rot.app.surveys.SurveyRepository;
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
                             ProposalRepository proposalRepository,
                             SurveyRepository surveyRepository,
                             QuestionnaireRepository questionnaireRepository,
                             AnswerRepository answerRepository) {
        return args -> {

            /*for (String name : Arrays.asList("Meier", "Meyer", "Mustermann")) {
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
                        if (part[distinctColumnIndex].equals(question.getQuestionDe())) {
                            question.setCategory(categoryMap.get(part[MigrateData.getColumnIndex("D") - 1]));
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
            int start = 0;
            int end = 5;
            for (String name : Arrays.asList("Survey 1", "Survey 2", "Survey 3")) {
                Survey survey = new Survey();
                survey.setName(name);
                survey.setDescription("Test Description for " + name);
                survey.setQuestions(questionRepository.findAll().subList(start, end));
                surveyRepository.save(survey);
                for (Question question : survey.getQuestions()) {
                    Answer answer = new Answer();
                    answer.setQuestion(question.getQuestionDe());
                    answer.setAnswer1("Test Answer 1");
                    answer.setAnswer2("Test Answer 2");
                    answer.setAnswer3("Test Answer 3");
                    answer.setAnswer4("Test Answer 4");
                    answer.setAnswer5("Test Answer 5");
                    answer.setAnswerNumber(0);
                    answerRepository.save(answer);
                }
                start += 15;
                end += 15;
            }

            Survey survey = surveyRepository.findAll().get(0);
            List<Answer> answers = new ArrayList<>();

            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setUser(userRepository.findAll().get(0));
            questionnaire.setSurvey(survey);
            questionnaire.setAnswers(answers);
            questionnaireRepository.save(questionnaire);*/
        };
    }


}