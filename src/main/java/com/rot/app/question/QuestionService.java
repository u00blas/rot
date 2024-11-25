package com.rot.app.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface QuestionService {
    Page<Question> findAll(PageRequest of);
}
