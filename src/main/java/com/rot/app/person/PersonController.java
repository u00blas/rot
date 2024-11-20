package com.rot.app.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("persons", persons);
        model.addAttribute("personDtos", personDtos);
        return "persons/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("personDto", new PersonDto());
        return "persons/edit";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        if (id == null) return "redirect:/persons";
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) return "redirect:/persons";
        PersonDto personDto = PersonDto.toDto(person);
        model.addAttribute("person", person);
        model.addAttribute("personDto", personDto);
        return "persons/edit";
    }

    @PostMapping("/save")
    public String save(PersonDto personDto) {
        Person person = PersonDto.fromDto(personDto);
        personRepository.save(person);
        return "redirect:/persons";
    }
}
