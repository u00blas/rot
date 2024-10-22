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
    @Column(nullable = false, unique = true, length = 255)
    private String question_de;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    public Question(Long id, String question_de, Category category, Proposal proposal) {
        this.id = id;
        this.question_de = question_de;
        this.category = category;
        this.proposal = proposal;
    }

    public Question(String question_de, Category category) {
        this.question_de = question_de;
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

    public Question(String question_de) {
        this.question_de = question_de;
    }

    public Question(Long id, String question_de) {
        this.id = id;
        this.question_de = question_de;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion_de() {
        return question_de;
    }

    public void setQuestion_de(String question_de) {
        this.question_de = question_de;
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
                ", question_de='" + question_de + '\'' +
                ", category=" + category +
                ", proposal=" + proposal +
                '}';
    }
}
