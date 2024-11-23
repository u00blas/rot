package com.rot.app.migration;

import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import com.rot.app.proposal.Proposal;
import com.rot.app.proposal.ProposalRepository;
import com.rot.app.questionnaire.Questionnaire;
import com.rot.app.questionnaire.QuestionnaireRepository;
import com.rot.app.replayoption.ReplayOption;
import com.rot.app.replayoption.ReplayOptionRepository;
import com.rot.app.question.Question;
import com.rot.app.question.QuestionRepository;
import com.rot.app.session.Session;
import com.rot.app.session.SessionRepository;
import com.rot.app.subquestion.Subquestion;
import com.rot.app.subquestion.SubquestionRepository;
import com.rot.app.subquestioncontainer.SubquestionContainer;
import com.rot.app.subquestioncontainer.SubquestionContainerRepository;
import com.rot.app.surveys.Survey;
import com.rot.app.surveys.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class MigrationService {

    private final ReplayOptionRepository replayOptionRepository;
    private final ProposalRepository proposalRepository;
    private final QuestionRepository questionRepository;
    private final SubquestionRepository subquestionRepository;
    private final SubquestionContainerRepository subquestionContainerRepository;
    private final CategoryRepository categoryRepository;
    private final QuestionnaireRepository questionnaireRepository;
    private final SurveyRepository surveyRepository;
    private final SessionRepository sessionRepository;

    public MigrationService(ReplayOptionRepository replayOptionRepository,
                            ProposalRepository proposalRepository,
                            QuestionRepository questionRepository,
                            SubquestionRepository subquestionRepository, SubquestionContainerRepository subquestionContainerRepository, CategoryRepository categoryRepository, QuestionnaireRepository questionnaireRepository, SurveyRepository surveyRepository, SessionRepository sessionRepository) {
        this.replayOptionRepository = replayOptionRepository;
        this.proposalRepository = proposalRepository;
        this.questionRepository = questionRepository;
        this.subquestionRepository = subquestionRepository;
        this.subquestionContainerRepository = subquestionContainerRepository;
        this.categoryRepository = categoryRepository;
        this.questionnaireRepository = questionnaireRepository;
        this.surveyRepository = surveyRepository;
        this.sessionRepository = sessionRepository;
    }


    public List<Category> getCategoriesFromCsv() {

        return null;
    }

    private List<ReplayOption> createReplayOptions() {

        List<String> lines = MigrateRawData.getLinesFromCsv();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 2; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");
            if (parts.length >= 30) {
                //System.out.println("ooo".repeat(80));
                if (!parts[24].isEmpty() && !parts[25].isEmpty()) {
                    map.put(parts[24] + " " + parts[25], List.of(parts[24], parts[25], parts[26], parts[27], parts[28], parts[29], parts[30]));
                } else {
                    //System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            } else {
                if (parts.length >= 27) {
                    //System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            }
        }

        map.forEach((key, value) -> {
            Proposal proposal = new Proposal();
            proposal.setName(key);
            proposal.setMinScale(value.get(0));
            proposal.setMaxScale(value.get(1));
            proposal.setDescription1(value.get(2));
            proposal.setDescription2(value.get(3));
            proposal.setDescription3(value.get(4));
            proposal.setDescription4(value.get(5));
            proposal.setDescription5(value.get(6));
            List<ReplayOption> list = new ArrayList<>();

            for (int i = 2; i < value.size(); i++) {
                if (value.get(i).isEmpty()) {
                    continue;
                }
                if (replayOptionRepository.findByName(value.get(i)) == null) {
                    ReplayOption replayOption = new ReplayOption(null, value.get(i));
                    try {
                        replayOptionRepository.save(replayOption);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                list.add(replayOptionRepository.findByName(value.get(i)));
            }
            proposal.setReplayOptions(list);
            proposalRepository.save(proposal);
        });
        return replayOptionRepository.findAll();

    }

    public List<Proposal> createProposals() {
        List<String> lines = MigrateRawData.getLinesFromCsv();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 2; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");
            if (parts.length >= 30) {
                //System.out.println("ooo".repeat(80));
                if (!parts[24].isEmpty() && !parts[25].isEmpty()) {
                    map.put(parts[24] + " " + parts[25], List.of(parts[24], parts[25], parts[26], parts[27], parts[28], parts[29], parts[30]));
                } else {
                   // System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            } else {
                if (parts.length >= 27) {
                    //System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            }
        }

        map.forEach((key, value) -> {
            Proposal proposal = new Proposal();
            proposal.setName(key);
            proposal.setMinScale(value.get(0));
            proposal.setMaxScale(value.get(1));
            proposal.setDescription1(value.get(2));
            proposal.setDescription2(value.get(3));
            proposal.setDescription3(value.get(4));
            proposal.setDescription4(value.get(5));
            proposal.setDescription5(value.get(6));
            List<ReplayOption> list = new ArrayList<>();

            for (int i = 2; i < value.size(); i++) {
                if (value.get(i).isEmpty()) {
                    continue;
                }
                if (replayOptionRepository.findByName(value.get(i)) == null) {
                    ReplayOption replayOption = new ReplayOption(null, value.get(i));
                    try {
                        replayOptionRepository.save(replayOption);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                list.add(replayOptionRepository.findByName(value.get(i)));
            }
            proposal.setReplayOptions(list);
            proposalRepository.save(proposal);
        });
        return proposalRepository.findAll();
    }

    public List<SubquestionContainer> createSubquestionContainers() {

        List<SubquestionContainer> subquestionContainers = new ArrayList<>();

        List<String> lines = MigrateRawData.getLinesFromCsv();
        {
            int position = 1;
            for (int i = 2; i < 9; i++) {
                String[] parts = lines.get(i).split(";");
                SubquestionContainer subquestionContainer = new SubquestionContainer();
                subquestionContainer.setQuestion(parts[22]);
                Subquestion subquestion = new Subquestion();
                subquestion.setQuestionDe("-");
                subquestion.setPosition(position);
                subquestion.setHeader(parts[22]);
                subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                subquestionContainer.setSubquestions(List.of(savedSubquestion));
                subquestionContainers.add(subquestionContainer);
            }
        }
        {
            int position = 1;
            SubquestionContainer subquestionContainer = null;
            List<Subquestion> subquestions = new ArrayList<>();
            for (int i = 9; i < 16; i++) {
                String[] parts = lines.get(i).split(";");
                if (i == 9) {
                    subquestionContainer = new SubquestionContainer();
                    subquestionContainer.setQuestion(parts[22]);
                } else {
                    Subquestion subquestion = new Subquestion();
                    subquestion.setHeader(subquestionContainer.getQuestion());
                    subquestion.setQuestionDe(parts[22]);
                    subquestion.setPosition(position);
                    subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                    Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                    subquestions.add(savedSubquestion);
                }
                position++;
            }
            subquestionContainer.setSubquestions(subquestions);
            subquestionContainers.add(subquestionContainer);
        }
        {
            int position = 1;
            for (int i = 16; i < 61; i++) {
                String[] parts = lines.get(i).split(";");
                SubquestionContainer subquestionContainer = new SubquestionContainer();
                subquestionContainer.setQuestion(parts[22]);
                Subquestion subquestion = new Subquestion();
                subquestion.setQuestionDe("-");
                subquestion.setPosition(position);
                subquestion.setHeader(parts[22]);
                subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                subquestionContainer.setSubquestions(List.of(savedSubquestion));
                subquestionContainers.add(subquestionContainer);
            }
        }
        {
            int position = 1;
            SubquestionContainer subquestionContainer = null;
            List<Subquestion> subquestions = new ArrayList<>();
            for (int i = 61; i < 71; i++) {
                String[] parts = lines.get(i).split(";");

                if (i == 61) {
                    subquestionContainer = new SubquestionContainer();
                    subquestionContainer.setQuestion(parts[22]);
                } else {
                    Subquestion subquestion = new Subquestion();
                    subquestion.setHeader(subquestionContainer.getQuestion());
                    subquestion.setPosition(position);
                    subquestion.setQuestionDe(parts[22]);
                    subquestion.setProposal(proposalRepository.findByName("ja nein"));
                    Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                    subquestions.add(savedSubquestion);
                }
                position++;
            }
            subquestionContainer.setSubquestions(subquestions);
            subquestionContainers.add(subquestionContainer);
        }
        {
            int position = 1;
            for (int i = 71; i < 119; i++) {
                String[] parts = lines.get(i).split(";");
                SubquestionContainer subquestionContainer = new SubquestionContainer();
                subquestionContainer.setQuestion(parts[22]);
                Subquestion subquestion = new Subquestion();
                subquestion.setQuestionDe("-");
                subquestion.setPosition(position);
                subquestion.setHeader(parts[22]);
                subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                subquestionContainer.setSubquestions(List.of(savedSubquestion));
                subquestionContainers.add(subquestionContainer);
            }
        }
        {
            int position = 1;
            SubquestionContainer subquestionContainer = null;
            List<Subquestion> subquestions = new ArrayList<>();
            for (int i = 119; i < 127; i++) {
                String[] parts = lines.get(i).split(";");

                if (i == 119) {
                    subquestionContainer = new SubquestionContainer();
                    subquestionContainer.setQuestion(parts[22]);
                } else {
                    Subquestion subquestion = new Subquestion();
                    subquestion.setHeader(subquestionContainer.getQuestion());
                    subquestion.setPosition(position);
                    subquestion.setQuestionDe(parts[22]);
                    subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                    Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                    subquestions.add(savedSubquestion);
                }
                position++;
            }
            subquestionContainer.setSubquestions(subquestions);
            subquestionContainers.add(subquestionContainer);
        }
        {
            int position = 1;
            SubquestionContainer subquestionContainer = null;
            List<Subquestion> subquestions = new ArrayList<>();
            for (int i = 127; i < 132; i++) {
                String[] parts = lines.get(i).split(";");

                if (i == 127) {
                    subquestionContainer = new SubquestionContainer();
                    subquestionContainer.setQuestion(parts[22]);
                } else {
                    Subquestion subquestion = new Subquestion();
                    subquestion.setHeader(subquestionContainer.getQuestion());
                    subquestion.setPosition(position);
                    subquestion.setQuestionDe(parts[22]);
                    subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                    Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                    subquestions.add(savedSubquestion);
                }
                position++;
            }
            subquestionContainer.setSubquestions(subquestions);
            subquestionContainers.add(subquestionContainer);
        }
        {
            int position = 1;
            SubquestionContainer subquestionContainer = null;
            List<Subquestion> subquestions = new ArrayList<>();
            for (int i = 132; i < 143; i++) {
                String[] parts = lines.get(i).split(";");

                if (i == 132) {
                    subquestionContainer = new SubquestionContainer();
                    subquestionContainer.setQuestion(parts[22]);
                } else {
                    Subquestion subquestion = new Subquestion();
                    subquestion.setHeader(subquestionContainer.getQuestion());
                    subquestion.setPosition(position);
                    subquestion.setQuestionDe(parts[22]);
                    subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                    Subquestion savedSubquestion = subquestionRepository.save(subquestion);
                    subquestions.add(savedSubquestion);
                }
                position++;
            }
            subquestionContainer.setSubquestions(subquestions);
            subquestionContainers.add(subquestionContainer);
        }

        subquestionContainerRepository.saveAll(subquestionContainers);
        return subquestionContainerRepository.findAll();
    }


    public List<Question> createQuestions() {

        List<Question> questions = new ArrayList<>();

        List<String> lines = MigrateRawData.getLinesFromCsv();
        Stream.of(new Pair(2, 10), new Pair(16, 62), new Pair(71, 120), new Pair(127, 128), new Pair(132, 133)).forEach(pair -> {
            {
                for (int i = pair.start; i < pair.end; i++) {
                    String[] parts = lines.get(i).split(";");
                    Question question = new Question(parts[22]);
                    question.setPage(parts[7]);
                    Category category = categoryRepository.findByName(parts[3]);
                    SubquestionContainer subquestionContainer = subquestionContainerRepository.findByQuestion(parts[22]);
                    question.setSubquestionContainer(subquestionContainer);
                    question.setTargetGroup(parts[2]);
                    question.setCategory(category);
                    question.setNewNumber(parts[8]);
                    questions.add(question);
                }
            }
        });
        return questions;
    }

    private Integer integer(String part) {
        if (part != null) {
            if (part.matches("\\d+")) {
                return Integer.parseInt(part);
            }
        }
        return null;
    }

    public List<Questionnaire> createQuestionnaires() {

        List<Questionnaire> questionnaires = new ArrayList<>();

        List.of("Fragebogen 1", "Fragebogen 2", "Fragebogen 3").forEach(name -> {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setName(name);
            questionnaire.setDescription("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.");
            questionnaires.add(questionnaire);
        });
        questionnaireRepository.saveAll(questionnaires);
        return questionnaireRepository.findAll();
    }

    public List<Survey> createSurveys() {
        List<Survey> surveys = new ArrayList<>();
        List.of("Umfrage 1", "Umfrage 2", "Umfrage 3").forEach(name -> {
            Survey survey = new Survey();
            survey.setName(name);
            survey.setDescription("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.");
            surveys.add(survey);
        });
        surveyRepository.saveAll(surveys);
        return surveyRepository.findAll();

    }

    public List<Session> createSessions() {
        List<Session> sessions = new ArrayList<>();
        {
            Session session = new Session();
            session.setSessionName("a1b2c3d4e5f6");
            session.setCreationDate(new Date());
            sessions.add(session);
        }
        {
            Session session = new Session();
            session.setSessionName("b1b2c3d4e5f6");
            session.setCreationDate(new Date());
            sessions.add(session);
        }
        {
            Session session = new Session();
            session.setSessionName("c1b2c3d4e5f6");
            session.setCreationDate(new Date());
            sessions.add(session);
        }

        sessionRepository.saveAll(sessions);
        return sessionRepository.findAll();
    }

    class Pair {
        private int start;
        private int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}