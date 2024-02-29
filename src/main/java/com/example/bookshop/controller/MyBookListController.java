package com.example.bookshop.controller;

import com.example.bookshop.service.MyBookListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class MyBookListController {
    private final MyBookListService myBookListService ;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyListById(@PathVariable (name = "id") Long id){
        myBookListService.deleteById(id);
        return "redirect:/myBooks";

    }
}
