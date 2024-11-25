package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import com.rot.app.subquestioncontainer.SubquestionContainer;
import jakarta.validation.constraints.NotEmpty;

public class QuestionDto {

    private Long id;
    @NotEmpty
    private String questionDe;
    private Category category;
    private SubquestionContainer subquestionContainer;
    private String questionEn;
    private String page;
    private String newNumber;
    private String ownNumber;
    private String sequenceNumber;
    private String targetGroup;
    private String unipark;

    public QuestionDto() {
    }

    public QuestionDto(Long id, String questionDe, Category category,
                       SubquestionContainer subquestionContainer, String questionEn,
                       String page, String newNumber, String ownNumber,
                       String sequenceNumber, String targetGroup, String unipark) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.subquestionContainer = subquestionContainer;
        this.questionEn = questionEn;
        this.page = page;
        this.newNumber = newNumber;
        this.ownNumber = ownNumber;
        this.sequenceNumber = sequenceNumber;
        this.targetGroup = targetGroup;
        this.unipark = unipark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty String getQuestionDe() {
        return questionDe;
    }

    public void setQuestionDe(@NotEmpty String questionDe) {
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

    public String getQuestionEn() {
        return questionEn;
    }

    public void setQuestionEn(String questionEn) {
        this.questionEn = questionEn;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(String newNumber) {
        this.newNumber = newNumber;
    }

    public String getOwnNumber() {
        return ownNumber;
    }

    public void setOwnNumber(String ownNumber) {
        this.ownNumber = ownNumber;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public String getUnipark() {
        return unipark;
    }

    public void setUnipark(String unipark) {
        this.unipark = unipark;
    }

    public static QuestionDto fromQuestion(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getQuestionDe(),
                question.getCategory(),
                question.getSubquestionContainer(),
                question.getQuestionEn(),
                question.getPage(),
                question.getNewNumber(),
                question.getOwnNumber(),
                question.getSequenceNumber(),
                question.getTargetGroup(),
                question.getUnipark()
        );
    }

    public static Question fromQuestionDto(QuestionDto questionDto) {
        return new Question(
                questionDto.getId(),
                questionDto.getQuestionDe(),
                questionDto.getCategory(),
                questionDto.getSubquestionContainer(),
                questionDto.getQuestionEn(),
                questionDto.getPage(),
                questionDto.getNewNumber(),
                questionDto.getOwnNumber(),
                questionDto.getSequenceNumber(),
                questionDto.getTargetGroup(),
                questionDto.getUnipark()
        );
    }
}
