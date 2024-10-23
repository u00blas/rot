package com.rot.app.surveys;

import com.rot.app.question.Question;
import com.rot.app.question.QuestionDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/surveys")
public class SurveyController {
    private final SurveyRepository surveyRepository;

    public SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @GetMapping
    public String getSurveys(Model model) {
        List<Survey> surveys = surveyRepository.findAll();
        List<SurveyDto> surveyDtos = new ArrayList<>();
        for (Survey survey : surveys) {
            SurveyDto surveyDto = SurveyDto.fromSurvey(survey);
            surveyDtos.add(surveyDto);
        }
        model.addAttribute("surveyDtos", surveyDtos);
        model.addAttribute("surveys", surveys);
        return "surveys/surveys";
    }

    @GetMapping("/details")
    public String getSurvey(Model model, @RequestParam Long id) {
        Survey survey = surveyRepository.findById(id).orElse(null);
        if (survey == null) {
            return "redirect:/surveys";
        }
        List<Question> questions = survey.getQuestions();
        List<QuestionDto> questionDtos = new ArrayList<>();
        for (Question question : questions) {
            QuestionDto questionDto = QuestionDto.fromQuestion(question);
            questionDtos.add(questionDto);
        }
        SurveyDto surveyDto = SurveyDto.fromSurvey(survey);
        model.addAttribute("surveyDto", surveyDto);
        model.addAttribute("survey", survey);
        model.addAttribute("questionDtos", questionDtos);
        return "surveys/survey_details";
    }
}
