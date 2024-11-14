package com.rot.app.session;

import jakarta.persistence.*;

@Entity
@Table(name = "session_sub_questions")
public class SessionSubQuestion {

    @Id
    @GeneratedValue
    private Long id;
    private String subQuestion;
    private Integer answer;

    @ManyToOne
    private SessionProposal sessionProposal;

    public SessionSubQuestion() {
    }

    public SessionSubQuestion(Long id, String subQuestion, Integer answer, SessionProposal sessionProposal) {
        this.id = id;
        this.subQuestion = subQuestion;
        this.answer = answer;
        this.sessionProposal = sessionProposal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubQuestion() {
        return subQuestion;
    }

    public void setSubQuestion(String subQuestion) {
        this.subQuestion = subQuestion;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public SessionProposal getSessionProposal() {
        return sessionProposal;
    }

    public void setSessionProposal(SessionProposal sessionProposal) {
        this.sessionProposal = sessionProposal;
    }

    @Override
    public String toString() {
        return "SessionSubQuestion{" +
                "id=" + id +
                ", subQuestion='" + subQuestion + '\'' +
                ", answer=" + answer +
                ", sessionProposal=" + sessionProposal +
                '}';
    }
}
