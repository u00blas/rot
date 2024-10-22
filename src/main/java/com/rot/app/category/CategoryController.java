package com.rot.app.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable("id") Long id) {
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return "category_form";
    }

    @GetMapping("/categories/{id}/delete")
    public String deleteCategory(@PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "category_form";
        }
        categoryRepository.deleteById(id);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/view")
    public String viewCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "category_view";
    }
}
