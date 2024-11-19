package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import com.rot.app.subquestion.Subquestion;
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

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    @ManyToOne
    private Subquestion subquestion;
    private String questionEn;
    private String page;
    private String newNumber;
    private String ownNumber;
    private String sequenceNumber;

    public Question() {
    }

    public Question(Long id, String questionDe, Category category, Proposal proposal, Subquestion subquestion, String questionEn, String page, String newNumber, String ownNumber, String sequenceNumber) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.proposal = proposal;
        this.subquestion = subquestion;
        this.questionEn = questionEn;
        this.page = page;
        this.newNumber = newNumber;
        this.ownNumber = ownNumber;
        this.sequenceNumber = sequenceNumber;
    }

    public Question(Long id, String questionDe, Category category, Proposal proposal, Subquestion subquestion, String questionEn, String page) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.proposal = proposal;
        this.subquestion = subquestion;
        this.questionEn = questionEn;
        this.page = page;
    }

    public Question(Long id, String questionDe, Category category, Proposal proposal, Subquestion subquestion, String questionEn) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.proposal = proposal;
        this.subquestion = subquestion;
        this.questionEn = questionEn;
    }

    public Question(Long id, String questionDe, Category category, Proposal proposal, Subquestion subquestion) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.proposal = proposal;
        this.subquestion = subquestion;
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

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Subquestion getSubquestion() {
        return subquestion;
    }

    public void setSubquestion(Subquestion subquestion) {
        this.subquestion = subquestion;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionDe='" + questionDe + '\'' +
                ", category=" + category +
                ", proposal=" + proposal +
                ", subquestion=" + subquestion +
                ", questionEn='" + questionEn + '\'' +
                ", page='" + page + '\'' +
                ", newNumber='" + newNumber + '\'' +
                ", ownNumber='" + ownNumber + '\'' +
                ", sequenceNumber='" + sequenceNumber + '\'' +
                '}';
    }

    public void setQuestionEn(String questionEn) {
        this.questionEn = questionEn;
    }

    public String getQuestionEn() {
        return questionEn;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public void setNewNumber(String newNumber) {
        this.newNumber = newNumber;
    }

    public String getNewNumber() {
        return newNumber;
    }

    public void setOwnNumber(String ownNumber) {
        this.ownNumber = ownNumber;
    }

    public String getOwnNumber() {
        return ownNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }
}
