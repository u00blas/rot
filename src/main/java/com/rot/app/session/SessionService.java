package com.rot.app.session;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final SessionPageRepository sessionPageRepository;

    public SessionService(SessionRepository sessionRepository,
                          SessionPageRepository sessionPageRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionPageRepository = sessionPageRepository;
    }

    public Session findBySessionId(String sessionId) {
        return sessionRepository.findBySessionId(sessionId);

    }

    public void saveSession(Session session) {
        List<SessionPage> pages = session.getPages();
        //sessionPageRepository.saveAll(pages);
        sessionRepository.save(session);
    }
}
