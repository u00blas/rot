package com.rot.app.question;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Page<Question> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> findAll(PageRequest pageRequest) {
        return questionRepository.findAll(pageRequest);
    }

    public QuestionDto findById(Long id) {
        Question question = questionRepository.findById(id).get();
        return QuestionDto.toDto(question);
    }

    public void update(Long id, @Valid QuestionDto questionDto) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            return;
        }
        question.setQuestionDe(questionDto.getQuestionDe());
        question.setQuestionEn(questionDto.getQuestionEn());
        question.setCategory(questionDto.getCategory());
        /*question.setSubquestionContainer(questionDto.getSubquestionContainer());

        question.setPage(questionDto.getPage());
        question.setNewNumber(questionDto.getNewNumber());
        question.setOwnNumber(questionDto.getOwnNumber());
        question.setSequenceNumber(questionDto.getSequenceNumber());
        question.setTargetGroup(questionDto.getTargetGroup());*/
        question.setUnipark(questionDto.getUnipark());
        question.setTrust1v1(questionDto.getTrust1v1());
        questionRepository.save(question);
    }
}
