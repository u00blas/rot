package com.rot.app.surveys;

import com.rot.app.question.QuestionDto;

import java.util.Collection;

public class SurveyDto {

    private String name;
    private String description;
    private Collection<QuestionDto> questions;

    public SurveyDto() {
    }

    public SurveyDto(String name, String description, Collection<QuestionDto> questions) {
        this.name = name;
        this.description = description;
        this.questions = questions;
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

    public Collection<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<QuestionDto> questions) {
        this.questions = questions;
    }
}
