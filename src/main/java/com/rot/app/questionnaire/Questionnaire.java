package com.rot.app.questionnaire;

import com.rot.app.answer.Answer;
import com.rot.app.question.Question;
import com.rot.app.user.User;
import com.rot.app.surveys.Survey;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    private List<Question> questions;

    public Questionnaire() {
    }

    public Questionnaire(Long id, String name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}
