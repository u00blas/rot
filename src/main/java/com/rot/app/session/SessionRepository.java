package com.rot.app.session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findBySessionId(String sessionId);
}
