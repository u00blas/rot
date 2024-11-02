package com.rot.app.appuser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    private final AppUserRepository appUserRepository;

    public AccountController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        return "register";
    }
}
