package com.arnaud.back.blibliotheque.services;

import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto>  findAllByBookTitleAndBookAuthorAndAndBookKide(String titre,String auteur,String genre);
    List<Book> findBookByAvailableTrue();
    List<Book> findBookByAvailableFalse();
    List<BookDto> findAll();



}
