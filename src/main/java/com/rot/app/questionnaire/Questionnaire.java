package com.rot.app.questionnaire;

import com.rot.app.user.User;
import com.rot.app.surveys.Survey;
import jakarta.persistence.*;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    private Survey survey;

    public Questionnaire() {
    }

    public Questionnaire(Long id, User user, Survey survey) {
        this.id = id;
        this.user = user;
        this.survey = survey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", user=" + user +
                ", survey=" + survey +
                '}';
    }
}
