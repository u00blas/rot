package com.rot.app.subquestion;

import com.rot.app.proposal.Proposal;
import jakarta.persistence.*;

@Entity
@Table(name = "subquestions")
public class Subquestion {

    @Id
    @GeneratedValue
    private Long id;

    private String question;
    @ManyToOne
    private Proposal proposal;

    private Integer answer;

    public Subquestion() {
    }

    public Subquestion(Long id, String question, Proposal proposal, Integer answer) {
        this.id = id;
        this.question = question;
        this.proposal = proposal;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Subquestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", proposal=" + proposal +
                ", answer=" + answer +
                '}';
    }
}
