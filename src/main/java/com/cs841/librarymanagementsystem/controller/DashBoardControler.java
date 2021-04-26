package com.cs841.librarymanagementsystem.controller;

import com.cs841.librarymanagementsystem.entity.Author;
import com.cs841.librarymanagementsystem.entity.Category;
import com.cs841.librarymanagementsystem.entity.Publisher;
import com.cs841.librarymanagementsystem.service.AuthorService;
import com.cs841.librarymanagementsystem.service.BookService;
import com.cs841.librarymanagementsystem.service.CategoryService;
import com.cs841.librarymanagementsystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DashBoardControler {
    private CategoryService categoryService;
    private AuthorService authorService;
    private BookService bookService ;
    private PublisherService publisherService;

    @Autowired
    public DashBoardControler(CategoryService categoryService,AuthorService authorService,
                              BookService bookService,PublisherService publisherService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.publisherService = publisherService;

    }

    @RequestMapping("/dashboard")
    public String findAllAuthors(Model model) {
        final List<Author> authors = authorService.findAllAuthors();

        model.addAttribute("authors", authors);
        return "admin-board";
    }

}
