package com.rot.app.surveys;

import com.rot.app.question.QuestionDto;

import java.util.Collection;
import java.util.List;

public class SurveyDto {

    private Long id;
    private String name;
    private String description;
    private List<QuestionDto> questions;

    public SurveyDto() {
    }

    public SurveyDto(Long id, String name, String description, List<QuestionDto> questions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public static SurveyDto fromSurvey(Survey survey) {
        List<QuestionDto> questions = survey.getQuestions().stream().map(QuestionDto::fromQuestion).toList();
        return new SurveyDto(survey.getId(), survey.getName(), survey.getDescription(), questions);
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

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public int getQuestionCount() {
        return questions == null ? 0 : questions.size();
    }
}
