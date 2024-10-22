package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
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

    public Question(Long id, String questionDe, Category category, Proposal proposal) {
        this.id = id;
        this.questionDe = questionDe;
        this.category = category;
        this.proposal = proposal;
    }

    public Question(String questionDe, Category category) {
        this.questionDe = questionDe;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Question() {
    }

    public Question(Long id) {
        this.id = id;
    }

    public Question(String questionDe) {
        this.questionDe = questionDe;
    }

    public Question(Long id, String questionDe) {
        this.id = id;
        this.questionDe = questionDe;
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

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionDe='" + questionDe + '\'' +
                ", category=" + category +
                ", proposal=" + proposal +
                '}';
    }
}
