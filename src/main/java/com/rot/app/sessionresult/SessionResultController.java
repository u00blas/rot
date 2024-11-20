package com.rot.app.sessionresult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sessionresults")
public class SessionResultController {

    private final SessionResultRepository sessionResultRepository;

    public SessionResultController(SessionResultRepository sessionResultRepository) {
        this.sessionResultRepository = sessionResultRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sessionResults", sessionResultRepository.findAll());
        return "sessionresults/index";
    }

}
