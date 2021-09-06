package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book>  findAllByBookTitleAndBookAuthorAndAndBookKide(String titre,String auteur,String genre);
    List<Book> findBookByAvailableTrue();
    List<Book> findBookByAvailableFalse();
    List<Book> findAll();



}
