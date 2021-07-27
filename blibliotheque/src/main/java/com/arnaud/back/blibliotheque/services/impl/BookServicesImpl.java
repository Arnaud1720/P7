package com.arnaud.back.blibliotheque.services.impl;


import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.repository.BookRepository;
import com.arnaud.back.blibliotheque.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServicesImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book>   findBookByAvailableTrue() {
       return bookRepository.findBookByAvailableTrue();
    }


    @Override
    public List<Book> findBookByAvailableFalse() {
        return bookRepository.findBookByAvailableFalse();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}







