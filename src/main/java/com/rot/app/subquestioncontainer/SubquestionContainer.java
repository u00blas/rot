package com.rot.app.subquestioncontainer;

import com.rot.app.subquestion.Subquestion;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "detail_questions")
public class SubquestionContainer {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    @ManyToMany
    private List<Subquestion> subquestions;

    public SubquestionContainer() {
    }

    public SubquestionContainer(Long id, String question, List<Subquestion> subquestions) {
        this.id = id;
        this.question = question;
        this.subquestions = subquestions;
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

    public List<Subquestion> getSubquestions() {
        return subquestions;
    }

    public void setSubquestions(List<Subquestion> subquestions) {
        this.subquestions = subquestions;
    }

    @Override
    public String toString() {
        return "DetailQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", subquestions=" + subquestions +
                '}';
    }
}
