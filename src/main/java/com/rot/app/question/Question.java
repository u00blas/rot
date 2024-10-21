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
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    public Question(Long id, String name, Category category, Proposal proposal) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.proposal = proposal;
    }

    public Question(String name, Category category) {
        this.name = name;
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

    public Question(String name) {
        this.name = name;
    }

    public Question(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", category=" + category +
                ", proposal=" + proposal +
                '}';
    }
}
