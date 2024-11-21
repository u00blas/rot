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
    private String description;
    @ManyToMany
    private List<Question> questions;

    public Questionnaire() {
    }

    public Questionnaire(Long id, String name, String description, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", description='" + description + '\'' +
                ", questions=" + questions +
                '}';
    }
}
