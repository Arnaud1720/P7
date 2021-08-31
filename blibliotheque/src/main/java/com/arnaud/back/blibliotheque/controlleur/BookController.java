package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.controlleur.api.BookApi;
import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController implements BookApi {
    @Autowired
    private BookService bookService;


    @Override
    public List<Book> findBookByAvailableTrue(@RequestParam(value = "available",defaultValue = "true")boolean available) {
        if(available){
            return bookService.findBookByAvailableTrue();
        }else{
            return bookService.findBookByAvailableFalse();
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> resultBookList = bookService.findAll();
        return resultBookList;
    }

    @Override
    public List<Book> findByBookTitleContains(String mc) {
        return bookService.findByBookTitleContains(mc);
    }


}
