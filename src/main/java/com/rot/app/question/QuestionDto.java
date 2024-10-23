package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import jakarta.validation.constraints.NotEmpty;

public class QuestionDto {

    private Long id;
    @NotEmpty(message = "Question cannot be empty")
    private String questionDe;
    private Category category;
    private Proposal proposal;

    public QuestionDto() {
    }

    public QuestionDto(String questionDe, Category category, Proposal proposal) {
        this.questionDe = questionDe;
        this.category = category;
        this.proposal = proposal;
    }

    public QuestionDto(Long id, String questionDe, Category category, Proposal proposal) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.proposal = proposal;
    }

    public static QuestionDto fromQuestion(Question question) {
        return new QuestionDto(question.getId(), question.getQuestionDe(), question.getCategory(), question.getProposal());
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

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
