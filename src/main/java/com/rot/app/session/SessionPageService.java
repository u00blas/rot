package com.rot.app.session;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionPageService {

    private final SessionPageRepository sessionPageRepository;
    private final SessionQuestionRepository sessionQuestionRepository;

    public SessionPageService(SessionPageRepository sessionPageRepository, SessionQuestionRepository sessionQuestionRepository) {
        this.sessionPageRepository = sessionPageRepository;
        this.sessionQuestionRepository = sessionQuestionRepository;
    }

    public void saveSessionPage(SessionPage sessionPage) {
        List<SessionQuestion> questions = sessionPage.getQuestions();
        //sessionQuestionRepository.saveAll(questions);
        sessionPageRepository.save(sessionPage);
    }
}
