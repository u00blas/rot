package com.rot.app.subquestion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        Subquestion subquestion = subquestionRepository.findById(id).orElse(null);
        if (subquestion == null) {
            model.addAttribute("subquestion", new Subquestion());
            return "subquestions/edit";
        }
        model.addAttribute("subquestion", subquestion);
        return "subquestions/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Subquestion subquestion) {
        subquestionRepository.save(subquestion);
        return "redirect:/subquestions";
    }
}
