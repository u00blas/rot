package com.rot.app.session;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session findBySessionId(String sessionId) {
        return sessionRepository.findBySessionId(sessionId);

    }
}
