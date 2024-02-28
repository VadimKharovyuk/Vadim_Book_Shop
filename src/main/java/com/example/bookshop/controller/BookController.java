package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    @GetMapping("/")
    public String home (){
        return "home";
    }
    @GetMapping("/book_register")
    public String book_register(){
        return "bookRegister";
    }
    @PostMapping("/save")
    public String saveBook(Book book){
        bookRepository.save(book);
        return "redirect:book_register";
    }
    @GetMapping("/available_book")
    public String  getAllBook(Model model){
        model.addAttribute("book", bookRepository.findAll());
        return "bookList";
    }
}
