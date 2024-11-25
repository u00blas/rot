package com.rot.app.person;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtos = persons.stream().map(PersonDto::toDto).toList();
        //model.addAttribute("persons", persons);
        model.addAttribute("personDtos", personDtos);
        return "persons/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        //model.addAttribute("person", new Person());
        model.addAttribute("personDto", new PersonDto());
        return "persons/edit";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        if (id == null) return "redirect:/persons";
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) return "redirect:/persons";
        PersonDto personDto = PersonDto.toDto(person);
        //model.addAttribute("person", person);
        model.addAttribute("personDto", personDto);
        return "persons/edit";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute PersonDto personDto, BindingResult result) {
        if (result.hasErrors()) {
            return "persons/edit";
        }
        Person person = PersonDto.fromDto(personDto);
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            personRepository.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            //return "redirect:/persons";
        }
        return "redirect:/persons";
    }
}
