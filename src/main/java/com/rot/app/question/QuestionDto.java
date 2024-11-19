package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import com.rot.app.subquestioncontainer.SubquestionContainer;
import jakarta.validation.constraints.NotEmpty;

public class QuestionDto {

    private Long id;
    @NotEmpty(message = "Question cannot be empty")
    private String questionDe;
    private Category category;
    private SubquestionContainer subquestionContainer;

    public QuestionDto() {
    }

    public QuestionDto(Long id, String questionDe, Category category, SubquestionContainer subquestionContainer) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.subquestionContainer = subquestionContainer;
    }

    public static QuestionDto fromQuestion(Question question) {
        return new QuestionDto(question.getId(), question.getQuestionDe(), question.getCategory(), question.getSubquestionContainer());
    }

    public @NotEmpty(message = "Question cannot be empty") String getQuestionDe() {
        return questionDe;
    }

    public void setQuestionDe(@NotEmpty(message = "Question cannot be empty") String questionDe) {
        this.questionDe = questionDe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubquestionContainer getSubquestionContainer() {
        return subquestionContainer;
    }

    public void setSubquestionContainer(SubquestionContainer subquestionContainer) {
        this.subquestionContainer = subquestionContainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
