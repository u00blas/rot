package com.rot.app.books;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/allBooks";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        BooksCreationDto booksForm = new BooksCreationDto();

        for (int i = 1; i <= 3; i++) {
            Book book = new Book();
            book.setId(bookService.getNextId());
            booksForm.addBook(book);
        }

        model.addAttribute("form", booksForm);
        return "books/createBooksForm";
    }

    @PostMapping("/save")
    public String saveBooks(@Valid @ModelAttribute BooksCreationDto form, BindingResult result, Model model) {
        System.out.println("Result " + result.toString());
        result.getModel().forEach((key, value) -> System.out.println(key + " " + value));
        if (result.hasErrors()) {
            return "books/createBooksForm";
        }

        bookService.saveAll(form.getBooks());
        form.getBooks().forEach(System.out::println);

        model.addAttribute("books", bookService.findAll());
        return "redirect:/books/all";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        List<Book> books = new ArrayList<>();
        bookService.findAll().iterator().forEachRemaining(books::add);

        model.addAttribute("form", new BooksCreationDto(books));
        return "books/editBooksForm";
    }

}
