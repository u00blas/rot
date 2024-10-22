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
    public String showCreateContactPage(Model model) {
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


    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam Long id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact == null) {
            return "redirect:/contacts";
        }
        model.addAttribute("contact", contact);

        ContactDto contactDto = new ContactDto();
        contactDto.setName(contact.getName());
        contactDto.setEmail(contact.getEmail());
        contactDto.setPhone(contact.getPhone());
        contactDto.setComment(contact.getComment());

        model.addAttribute("contactDto", contactDto);

        return "contacts/contact_edit";
    }

    @PostMapping("/edit")
    public String editContact(
            Model model,
            @RequestParam Long id,
            @Valid @ModelAttribute ContactDto contactDto,
            BindingResult result) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact == null) {
            return "redirect:/contacts";
        }

        model.addAttribute("contact", contact);

        if (result.hasErrors()) {
            return "contacts/contact_edit";
        }
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        contact.setComment(contactDto.getComment());
        contactRepository.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete")
    public String deleteContact(@RequestParam Long id) {
        contactRepository.deleteById(id);
        return "redirect:/contacts";
    }
}
