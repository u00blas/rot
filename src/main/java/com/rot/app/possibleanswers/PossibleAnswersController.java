package com.rot.app.possibleanswers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PossibleAnswersController {
    private final PossibleAnswersRepository possibleAnswersRepository;

    public PossibleAnswersController(PossibleAnswersRepository possibleAnswersRepository) {
        this.possibleAnswersRepository = possibleAnswersRepository;
    }

    @GetMapping("/possible_answers")
    public List<PossibleAnswers> getAllPossibleAnswers() {
        return possibleAnswersRepository.findAll();
    }

    @GetMapping("/possible_answers/new")
    public String showNewPossibleAnswersForm(Model model) {
        model.addAttribute("possibleAnswers", new PossibleAnswers());
        return "possible_answer_form";
    }
}
