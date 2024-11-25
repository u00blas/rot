package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import com.rot.app.subquestion.Subquestion;
import com.rot.app.subquestioncontainer.SubquestionContainer;
import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_de")
    private String questionDe;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    private SubquestionContainer subquestionContainer;

    private String questionEn;
    private String page;
    private String newNumber;
    private String ownNumber;
    private String sequenceNumber;
    private String targetGroup;
    private String unipark;

    public Question() {
    }

    public Question(Long id, String questionDe, Category category,
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

    public Question(String w) {
        this.questionDe = w;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionDe() {
        return questionDe;
    }

    public void setQuestionDe(String questionDe) {
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

    public String getUnipark() {
        return unipark;
    }

    public void setUnipark(String unipark) {
        this.unipark = unipark;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", targetGroup='" + targetGroup + '\'' +
                ", newNumber='" + newNumber + '\'' +
                ", questionDe='" + questionDe + '\'' +
                ", category=" + category +
                ", subquestionContainer=" + subquestionContainer +
                ", questionEn='" + questionEn + '\'' +
                ", page='" + page + '\'' +
                ", ownNumber='" + ownNumber + '\'' +
                ", sequenceNumber='" + sequenceNumber + '\'' +
                ", unipark='" + unipark + '\'' +
                '}';
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public String getTargetGroup() {
        return targetGroup;
    }
}
