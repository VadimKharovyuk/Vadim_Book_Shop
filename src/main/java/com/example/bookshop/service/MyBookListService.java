package com.example.bookshop.service;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.MyBookList;
import com.example.bookshop.repository.MyBookListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyBookListService {
    private final MyBookListRepository myBookListRepository ;


    public void saveMyBook(MyBookList myBookList){
        myBookListRepository.save(myBookList);

    }


    public List<MyBookList> findAllMyBookList(MyBookList myBookList){
        return  myBookListRepository.findAll();

    }
    public void deleteById(Long id){
        myBookListRepository.deleteById(id);
    }




}
