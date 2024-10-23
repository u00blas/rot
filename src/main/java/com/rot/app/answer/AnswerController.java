package com.rot.app.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @GetMapping
    public String getAnswers(Model model) {
        model.addAttribute("answers", answerRepository.findAll());
        return "answers/answer_list";
    }


}
