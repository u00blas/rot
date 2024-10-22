package com.rot.app.contact;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping
    public String listAllContacts(Model model) {
        List<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "contacts/contacts";
    }

    @GetMapping("/create")
    public String showCreateContactForm(Model model) {
        model.addAttribute("contactDto", new ContactDto());
        return "contacts/contact_create";
    }

    @PostMapping("/create")
    public String createContact(
            @Valid @ModelAttribute ContactDto contactDto,
            BindingResult result
    ) {
        if (contactRepository.findByEmail(contactDto.getEmail()) != null) {
            result.addError(
                    new FieldError("contactDto", "email", contactDto.getEmail(),
                            false, null, null, "Email already exists"));
        }
        if (result.hasErrors()) {
            return "contacts/contact_create";
        }
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        contact.setComment(contactDto.getComment());
        contactRepository.save(contact);
        return "redirect:/contacts";
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
