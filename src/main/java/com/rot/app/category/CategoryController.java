package com.rot.app.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        model.addAttribute("categoryDto", CategoryDto.from(category));
        return "categories/edit";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("categoryDto", new CategoryDto());
        return "categories/edit";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("categoryDto") CategoryDto categoryDto, BindingResult bindingResult) {

        if (categoryDto.getId() == null) {
            Category newCategory = new Category();
            newCategory.setDescription(categoryDto.getDescription());
            newCategory.setName(categoryDto.getName());
            newCategory.setCreationDate(new Date());
            categoryService.save(newCategory);
            return "redirect:/categories";
        }
        Category category = categoryService.findById(categoryDto.getId());
        if (category == null) {
            return "redirect:/categories";
        }
        category.setLastUpdate(new Date());
        category.setDescription(categoryDto.getDescription());
        category.setName(categoryDto.getName());
        categoryService.save(category);
        return "redirect:/categories";
    }
}
