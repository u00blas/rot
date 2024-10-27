package com.rot.app.asking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/askings")
public class AskingController {

    @GetMapping
    public String getAsking(Model model) {
        List<Asking> askings = new ArrayList<>();
        askings.add(new Asking("How old are you?", List.of("< 18", "> 18"), null));
        askings.add(new Asking("How many people live in your house?", List.of("1", "2", "3","4","more"), null));
        askings.add(new Asking("Do you have pets?", List.of("no", "yes", "no answer"), null));
        askings.add(new Asking("Did you have any siblings?", List.of("yes", "no", "no answer"), null));
        model.addAttribute("askings", askings);
        return "asking/askings";
    }

    @PostMapping("/save")
    public String saveAsking(@ModelAttribute("askings") List<Asking> askings) {

        System.out.println(askings);

        return "redirect:/askings";
    }
}
