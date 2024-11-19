package com.rot.app.migration.raw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/raw")
public class RawCsvController {

    private final RawCsvRepository rawCsvRepository;

    public RawCsvController(RawCsvRepository rawCsvRepository) {
        this.rawCsvRepository = rawCsvRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("raws", rawCsvRepository.findAll());
        return "raw/index";
    }
}
