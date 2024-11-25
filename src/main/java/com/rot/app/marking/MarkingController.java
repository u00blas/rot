package com.rot.app.marking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/markings")
public class MarkingController {

    private final MarkingService markingService;


    public MarkingController(MarkingService markingService) {
        this.markingService = markingService;
    }

    @GetMapping
    public String listAllMarkings(Model model) {
        model.addAttribute("markingDtos", markingService.findAll());
        return "markings/index";
    }

    @GetMapping("/create")
    public String showCreateMarkingForm(Model model) {
        model.addAttribute("markingDto", new MarkingDto());
        return "markings/edit";
    }

    @PostMapping("/save")
    public String saveMarking(@ModelAttribute MarkingDto markingDto) {
        markingService.save(markingDto);
        return "redirect:/markings";
    }

    @GetMapping("/delete")
    public String deleteMarking(@RequestParam Long id) {
        markingService.delete(id);
        return "redirect:/markings";
    }

    @GetMapping("/edit")
    public String showEditMarkingForm(Model model, @RequestParam Long id) {
        if (id == null) return "redirect:/markings";
        MarkingDto markingDto = markingService.findAll().stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
        if (markingDto == null) return "redirect:/markings";
        model.addAttribute("markingDto", markingDto);
        return "markings/edit";
    }


}
