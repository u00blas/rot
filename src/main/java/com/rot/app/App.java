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
import com.rot.app.session.*;
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
                             AnswerRepository answerRepository,
                             SessionRepository sessionRepository,
                             SessionPageRepository sessionPageRepository,
                             SessionQuestionRepository sessionQuestionRepository,
                             SessionProposalRepository sessionProposalRepository) {
        return args -> {

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

            for (int proposal : Arrays.asList(1, 2, 3)) {
                SessionProposal sessionProposal = new SessionProposal();
                sessionProposal.setMinScale("Minimum Scale " + proposal);
                sessionProposal.setMaxScale("Maximum Scale " + proposal * 100);
                sessionProposal.setDescription1("Description 1 " + proposal * 10);
                sessionProposal.setDescription2("Description 2 " + proposal * 20);
                sessionProposal.setDescription3("Description 3 " + proposal * 40);
                sessionProposal.setDescription4("Description 4 " + proposal * 80);
                sessionProposal.setDescription5("Description 5 " + proposal * 100);
                sessionProposalRepository.save(sessionProposal);

            }

            for (String question : Arrays.asList("what?", "who?", "why?", "where?", "when?", "how?", "which?", "who is this?", "what is this?", "where is this?", "why is this?", "when is this?", "how is this?")) {
                SessionQuestion sessionQuestion = new SessionQuestion();
                sessionQuestion.setQuestion(question);
                sessionQuestion.setProposals(sessionProposalRepository.findAll());
                sessionQuestionRepository.save(sessionQuestion);
            }
            int pos = 0;

            for (Integer i : Arrays.asList(1, 2, 3)) {
                SessionPage sessionPage = new SessionPage();
                sessionPage.setPageId(i);
                sessionPage.setData("Page " + i);
                sessionPage.setQuestions(sessionQuestionRepository.findAll().subList(pos, pos + 2));
                pos += 3;
                sessionPageRepository.save(sessionPage);
            }
            for (String s : Arrays.asList("2h45f88def90ff8", "4h45f88def90ff8", "6h45f88def90ff8")) {
                Session session = new Session();
                session.setSessionId(s);
                session.setCreatedAt(new Date());
                session.setExpiresAt(new Date());
                session.setData("Session " + s);
                session.setPages(sessionPageRepository.findAll());
                sessionRepository.save(session);
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
            questionnaireRepository.save(questionnaire);
        };
    }


}