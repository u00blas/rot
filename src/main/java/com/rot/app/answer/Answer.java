package com.rot.app.answer;

import com.rot.app.proposal.Proposal;
import com.rot.app.question.Question;
import com.rot.app.questionnaire.Questionnaire;
import com.rot.app.surveys.Survey;
import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;
    private Integer selectedAnswerId;

    public Answer() {
    }

    public Answer(Long id, Question question, Proposal proposal, Survey survey, Questionnaire questionnaire, Integer selectedAnswerId) {
        this.id = id;
        this.question = question;
        this.proposal = proposal;
        this.survey = survey;
        this.questionnaire = questionnaire;
        this.selectedAnswerId = selectedAnswerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Integer getSelectedAnswerId() {
        return selectedAnswerId;
    }

    public void setSelectedAnswerId(Integer selectedAnswerId) {
        this.selectedAnswerId = selectedAnswerId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", question=" + question +
                ", proposal=" + proposal +
                ", survey=" + survey +
                ", questionnaire=" + questionnaire +
                ", selectedAnswerId=" + selectedAnswerId +
                '}';
    }
}
