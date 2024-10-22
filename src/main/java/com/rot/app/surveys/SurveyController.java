package com.rot.app.surveys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {
    private final SurveyRepository surveyRepository;

    public SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @GetMapping("/surveys")
    public String getSurveys(Model model) {
        model.addAttribute("surveys", surveyRepository.findAll());
        return "surveys/surveys";
    }
}
