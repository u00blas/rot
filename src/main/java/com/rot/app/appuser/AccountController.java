package com.rot.app.appuser;

import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

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
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registerDto") RegisterDto registerDto, Model model, BindingResult result) {
        if(!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(new FieldError("registerDto", "confirmPassword", "Passwords do not match"));
        }

        AppUser appUser = appUserRepository.findByEmail(registerDto.getEmail());
        if(appUser != null) {
            result.addError(new FieldError("registerDto", "email", "Email already in use"));
        }

        if(result.hasErrors()) {
            return "register";
        }

        try{
            var bCryptEncoder = new BCryptPasswordEncoder();

            AppUser newUser= new AppUser();
            newUser.setFirstName(registerDto.getFirstName());
            newUser.setLastName(registerDto.getLastName());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPhone(registerDto.getPhone());
            newUser.setAddress(registerDto.getAddress());
            newUser.setRole("client");
            newUser.setCreatedAt(new Date());
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));


            appUserRepository.save(newUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);

        }catch (Exception e) {
            result.addError(new FieldError("registerDto", "firstName", e.getMessage()));
        }
        //appUserRepository.save(registerDto.toAppUser());
        return "redirect:/login";
    }
}
