package com.rot.app.subquestion;

import com.rot.app.proposal.Proposal;
import jakarta.persistence.*;

@Entity
@Table(name = "subquestions")
public class Subquestion {

    @Id
    @GeneratedValue
    private Long id;
    private String header;
    private Integer position;
    private String questionDe;
    @ManyToOne
    private Proposal proposal;

    private Integer answer;

    public Subquestion() {
    }

    public Subquestion(Long id, String header, Integer position, String questionDe, Proposal proposal, Integer answer) {
        this.id = id;
        this.header = header;
        this.position = position;
        this.questionDe = questionDe;
        this.proposal = proposal;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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
                ", header='" + header + '\'' +
                ", position=" + position +
                ", questionDe='" + questionDe + '\'' +
                ", proposal=" + proposal +
                ", answer=" + answer +
                '}';
    }
}
