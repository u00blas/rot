package com.rot.app.session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionQuestionRepository extends JpaRepository<SessionQuestion, Long> {
}