package com.rot.app.key;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/keys")
public class KeyController {

    private final KeyRepository keyRepository;

    public KeyController(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("keys", keyRepository.findAll());
        return "keys/index";
    }
}
