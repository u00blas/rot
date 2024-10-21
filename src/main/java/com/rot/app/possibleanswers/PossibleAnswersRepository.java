package com.rot.app.possibleanswers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossibleAnswersRepository extends JpaRepository<PossibleAnswers, Long> {
}
