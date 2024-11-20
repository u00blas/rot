package com.rot.app.sessionresult;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionResultRepository extends JpaRepository<SessionResult, Long> {
    List<SessionResult> findBySessionName(String sessionName);
}
