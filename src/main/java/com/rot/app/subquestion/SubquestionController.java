package com.rot.app.subquestion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subquestions")
public class SubquestionController {

    private final SubquestionRepository subquestionRepository;

    public SubquestionController(SubquestionRepository subquestionRepository) {
        this.subquestionRepository = subquestionRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("subquestions", subquestionRepository.findAll());
        return "subquestions/index";
    }
}
