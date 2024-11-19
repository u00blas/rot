package com.rot.app.subquestioncontainer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subquestionContainers")
public class SubquestionContainerController {

    private final SubquestionContainerRepository subquestionContainerRepository;

    public SubquestionContainerController(SubquestionContainerRepository subquestionContainerRepository) {
        this.subquestionContainerRepository = subquestionContainerRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("subquestionContainers", subquestionContainerRepository.findAll());
        return "subquestionContainers/index";
    }
}
