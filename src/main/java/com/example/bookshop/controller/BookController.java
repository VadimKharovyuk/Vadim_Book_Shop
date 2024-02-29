package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.MyBookList;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.MyBookListRepository;
import com.example.bookshop.service.BookService;
import com.example.bookshop.service.MyBookListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class BookController {
    private final BookService bookService ;
    private final MyBookListService myBookListService ;
    @GetMapping("/")
    public String home (){
        return "home";
    }
    @GetMapping("/book_register")
    public String book_register(){
        return "bookRegister";


    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute  Book book){

      bookService.save(book);
        return "redirect:/book_register";
    }
    @GetMapping("/available_book")
    public String  getAllBook(Model model){
      Book book = new Book();
        model.addAttribute("book", bookService.findAll(book));
        return "bookList";
    }
    @GetMapping("/myBooks")
    public String getMyBook(Model model){
        model.addAttribute("myBooks",myBookListService.findAllMyBookList(new MyBookList()));
        return "myBooks";
    }

   @RequestMapping("/mylist/{id}")
    public String getmyList(@PathVariable (name = "id") Long id ){
        Book book =bookService.getBookById(id);
       MyBookList myBookList = new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
     myBookListService.saveMyBook(myBookList);

       return "redirect:/myBooks";
   }
   @RequestMapping("/bookEdit/{id}")
    public String editBook(@PathVariable (name = "id") Long id ,Model model){
       Book book = bookService.getBookById(id);
       model.addAttribute("book",book);
        return "bookEdit";
   }
   @RequestMapping("/deleteBook/{id}")
    public String deleteBook( @PathVariable ("id") Long id){
        bookService.deleteByID(id);
        return "redirect:/available_book";
   }

}
