package com.rot.app.question;

import com.rot.app.category.Category;
import com.rot.app.category.CategoryRepository;
import com.rot.app.proposal.Proposal;
import com.rot.app.proposal.ProposalRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;
    private final ProposalRepository proposalRepository;


    public QuestionController(QuestionRepository questionRepository,
                              CategoryRepository categoryRepository,
                              ProposalRepository proposalRepository
    ) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
        this.proposalRepository = proposalRepository;

    }

    @GetMapping
    public String listAllQuestions(Model model) {
        return getOnePage(model, 1);
    }

    @GetMapping("/page")
    public String getOnePage(Model model, @RequestParam int pageNumber) {
        Page<Question> page = questionRepository.findAll(PageRequest.of(pageNumber - 1, 20));
        int totalPages = page.getTotalPages();
        if (pageNumber > totalPages) {
            return "redirect:/questions?pageNumber=" + (totalPages - 1) + "&pageSize=" + 20;
        }
        long totalItems = page.getTotalElements();
        List<Question> questions = page.getContent();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("questions", questions);
        return "questions/questions";
    }

    @GetMapping("/create")
    public String showCreateQuestionForm(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<Proposal> proposals = proposalRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("proposals", proposals);
        model.addAttribute("questionDto", new QuestionDto());
        return "questions/question_create";
    }

    @PostMapping("/create")
    public String createQuestion(
            @Valid @ModelAttribute QuestionDto questionDto,
            BindingResult result
    ) {
        if (questionRepository.findByQuestionDe(questionDto.getQuestionDe()) != null) {
            result.addError(
                    new FieldError("questionDto", "email", questionDto.getQuestionDe(),
                            false, null, null, "Question already exists"));
        }
        if (result.hasErrors()) {
            return "questions/question_create";
        }
        Question question = new Question();
        question.setQuestionDe(questionDto.getQuestionDe());
        question.setCategory(questionDto.getCategory());
        question.setProposal(questionDto.getProposal());
        questionRepository.save(question);
        return "redirect:/questions";
    }

    @GetMapping("/questions/{id}/edit")
    public String showEditQuestionForm(Model model, @PathVariable("id") Long id) {
        List<Category> categories = categoryRepository.findAll();
        List<Proposal> proposals = proposalRepository.findAll();
        model.addAttribute("proposals", proposals);
        model.addAttribute("categories", categories);
        model.addAttribute("question", questionRepository.findById(id).get());
        return "question_form";
    }

    @GetMapping("/questions/{id}/delete")
    public String deleteQuestion(@PathVariable("id") Long id) {
        questionRepository.deleteById(id);
        return "redirect:/questions";
    }

    @GetMapping("/questions/{id}/view")
    public String viewQuestion(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        return "question_view";
    }
}
