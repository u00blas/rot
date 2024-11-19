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

    @GetMapping("/edit")
    public String showEditQuestionForm(Model model, @RequestParam Long id) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            return "redirect:/questions";
        }
        model.addAttribute("question", question);
        List<Category> categories = categoryRepository.findAll();
        List<Proposal> proposals = proposalRepository.findAll();
        model.addAttribute("proposals", proposals);
        model.addAttribute("categories", categories);
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionDe(question.getQuestionDe());
        questionDto.setCategory(question.getCategory());
        questionDto.setProposal(question.getProposal());
        model.addAttribute("questionDto", questionDto);
        return "questions/question_edit";
    }

    @PostMapping("/edit")
    public String editQuestion(
            Model model,
            @RequestParam Long id,
            @Valid @ModelAttribute QuestionDto questionDto,
            BindingResult result) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            return "redirect:/questions";
        }
        model.addAttribute("question", question);
        if (!question.getQuestionDe().equals(questionDto.getQuestionDe())
                && questionRepository.findByQuestionDe(questionDto.getQuestionDe()) != null) {
            result.addError(
                    new FieldError("questionDto", "questionDe", questionDto.getQuestionDe(),
                            false, null, null, "Question already exists"));
        }
        if (result.hasErrors()) {
            return "questions/question_edit";
        }
        question.setQuestionDe(questionDto.getQuestionDe());
        question.setCategory(questionDto.getCategory());
        question.setProposal(questionDto.getProposal());
        questionRepository.save(question);
        return "redirect:/questions";
    }

    @GetMapping("/questions/delete")
    public String deleteQuestion(@RequestParam Long id) {
        questionRepository.deleteById(id);
        return "redirect:/questions";
    }

    @GetMapping("/questions/details")
    public String details(@RequestParam Long id, Model model) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            return "redirect:/questions";
        }
        model.addAttribute("question", question);
        return "questions/details";
    }
}
