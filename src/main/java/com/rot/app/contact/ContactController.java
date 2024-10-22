package com.rot.app.contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contacts/create")
    public String showCreateContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact_form";
    }

    @PostMapping("/contacts/save")
    public String createContact(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts")
    public String listAllContacts(Model model) {
        List<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "contacts/index";
    }

    @GetMapping("/contacts/{id}/edit")
    public String showEditContactForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("contact", contactRepository.findById(id).get());
        return "contact_form";
    }

    @GetMapping("/contacts/{id}/delete")
    public String deleteContact(@PathVariable("id") Long id) {
        contactRepository.deleteById(id);
        return "redirect:/contacts";
    }
}
