package com.rot.app.questionnaire;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {
    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @GetMapping
    public String getQuestionnaires(Model model) {
        model.addAttribute("questionnaires", questionnaireRepository.findAll());
        return "questionnaires/questionnaire_list";
    }

}
