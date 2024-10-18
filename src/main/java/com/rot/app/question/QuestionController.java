package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    public QuestionController(QuestionRepository questionRepository, CategoryRepository categoryRepository) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/questions")
    public String listAllQuestions(Model model) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        return "questions";
    }

    @GetMapping("/questions/new")
    public String showCreateQuestionForm(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("question", new Question());
        return "question_form";
    }

    @PostMapping("/questions/save")
    public String saveQuestion(Question question) {
        questionRepository.save(question);
        return "redirect:/questions";
    }

    @GetMapping("/questions/{id}/edit")
    public String showEditQuestionForm(Model model, @PathVariable("id") Long id) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("question", questionRepository.findById(id).get());
        return "question_form";
    }
}
