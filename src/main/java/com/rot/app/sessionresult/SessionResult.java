package com.rot.app.sessionresult;

import com.rot.app.session.Session;
import com.rot.app.subquestion.Subquestion;
import jakarta.persistence.*;

@Entity
@Table(name = "session_results")
public class SessionResult {

    @Id
    @GeneratedValue
    private Long id;

    private String sessionName;

    @ManyToOne
    private Subquestion subquestion;

    private String answer;

    public SessionResult() {
    }

    public SessionResult(Long id, String sessionName, Subquestion subquestion, String answer) {
        this.id = id;
        this.sessionName = sessionName;
        this.subquestion = subquestion;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Subquestion getSubquestion() {
        return subquestion;
    }

    public void setSubquestion(Subquestion subquestion) {
        this.subquestion = subquestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SessionResult{" +
                "id=" + id +
                ", sessionName='" + sessionName + '\'' +
                ", subquestion=" + subquestion +
                ", answer='" + answer + '\'' +
                '}';
    }
}
