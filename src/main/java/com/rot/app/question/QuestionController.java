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

    private final QuestionServiceImpl questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String listAllQuestions(Model model) {
        return getOnePage(model, 1);
    }

    @GetMapping("/page")
    public String getOnePage(Model model, @RequestParam int pageNumber) {
        Page<Question> page = questionService.findAll(PageRequest.of(pageNumber - 1, 20));
        int totalPages = page.getTotalPages();
        if (pageNumber > totalPages) {
            return "redirect:/questionDtos?pageNumber=" + (totalPages - 1) + "&pageSize=" + 20;
        }
        long totalItems = page.getTotalElements();
        List<QuestionDto> questionDtos = page.getContent().stream().map(QuestionDto::toDto).toList();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("questionDtos", questionDtos);
        return "questions/index";
    }


}
