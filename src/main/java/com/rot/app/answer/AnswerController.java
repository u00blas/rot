package com.rot.app.answer;

import com.rot.app.contact.Contact;
import com.rot.app.contact.ContactDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @GetMapping
    public String getAnswers(Model model) {
        List<AnswerDto> answerDtos = answerRepository.findAll().stream().map(AnswerDto::fromEntity).toList();
        model.addAttribute("answers", answerDtos);
        return "answers/answer_list";
    }

    @PostMapping("/save")
    public String saveAnswer(AnswerDto answerDto) {
        Answer answer = AnswerDto.fromDto(answerDto);
        answerRepository.save(answer);
        return "redirect:/answers";
    }

}
