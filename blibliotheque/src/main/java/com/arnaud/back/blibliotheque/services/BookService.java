package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Book;

import java.util.List;

public interface BookService {


    List<Book> findBookByAvailableTrue();
    List<Book> findBookByAvailableFalse();
    List<Book> findAll();


}
