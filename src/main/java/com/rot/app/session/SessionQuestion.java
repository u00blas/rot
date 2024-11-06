package com.rot.app.session;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

@Entity
@Table(name = "session_questions")
public class SessionQuestion {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "session_question_proposal",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "proposal_id"))
    private List<SessionProposal> proposals;
    private Integer answer;

    public SessionQuestion() {

    }

    public SessionQuestion(Long id, String question, List<SessionProposal> proposals, Integer answer) {
        this.id = id;
        this.question = question;
        this.proposals = proposals;
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

    public List<SessionProposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<SessionProposal> proposals) {
        this.proposals = proposals;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SessionQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", proposals=" + proposals +
                ", answer=" + answer +
                '}';
    }
}
