package com.example.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @GetMapping("/")
    public String home (){
        return "home";
    }
    @GetMapping("/book_register")
    public String book_register(){
        return "bookRegister";
    }
    @GetMapping("/available_book")
    public String  getAllBook(){
        return "bookList";
    }
}
