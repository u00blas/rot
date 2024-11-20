package com.rot.app.session;

import com.rot.app.question.Question;
import com.rot.app.questionnaire.Questionnaire;
import com.rot.app.sessionresult.SessionResult;
import com.rot.app.sessionresult.SessionResultContainer;
import com.rot.app.sessionresult.SessionResultRepository;
import com.rot.app.subquestion.Subquestion;
import com.rot.app.subquestioncontainer.SubquestionContainer;
import com.rot.app.surveys.Survey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final SessionRepository sessionRepository;
    private final SessionResultRepository sessionResultRepository;

    public SessionController(SessionRepository sessionRepository, SessionResultRepository sessionResultRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionResultRepository = sessionResultRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sessions", sessionRepository.findAll());
        return "sessions/index";
    }

    @GetMapping("/collect/{sessionName}")
    public String collect(@PathVariable String sessionName, Model model) {
        Session session = sessionRepository.findBySessionName(sessionName);
        if (session == null) {
            return "redirect:/sessions";
        }
        List<SessionResult> sessionResultList = sessionResultRepository.findBySessionName(sessionName);
        if (sessionResultList.isEmpty()) {
            List<SessionResult> sessionResults = new ArrayList<>();
            for (Question question : session.getSurvey().getQuestionnaire().getQuestions()) {
                for (Subquestion subquestion : question.getSubquestionContainer().getSubquestions()) {
                    SessionResult sessionResult = new SessionResult();
                    sessionResult.setSessionName(sessionName);
                    sessionResult.setSubquestion(subquestion);
                    sessionResults.add(sessionResult);
                }
            }
            sessionResultRepository.saveAll(sessionResults);
        }
        List<SessionResult> sessionResults = sessionResultRepository.findBySessionName(sessionName);
        SessionResultContainer sessionResultContainer = new SessionResultContainer();
        sessionResultContainer.setSessionResults(sessionResults);
        model.addAttribute("sessionResultContainer", sessionResultContainer);
        model.addAttribute("sessionDto", session);
        return "sessions/collect";
    }

    @PostMapping("/collect")
    public String collect(@ModelAttribute SessionResultContainer sessionResultContainer, Model model) {
        sessionResultContainer.getSessionResults()
                .forEach(sessionResult -> {
                    sessionResultRepository.findById(sessionResult.getId())
                            .ifPresent(existingSessionResult -> {
                                sessionResult.setSessionName(existingSessionResult.getSessionName());
                                sessionResult.setSubquestion(existingSessionResult.getSubquestion());
                                //sessionResult.setAnswer(existingSessionResult.getAnswer());
                                sessionResultRepository.save(sessionResult);
                            });
                });
        model.addAttribute("conclusion", "Thank you for your answers!");
        return "sessions/greetings";
    }
}
