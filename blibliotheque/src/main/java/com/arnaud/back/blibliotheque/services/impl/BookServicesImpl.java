package com.arnaud.back.blibliotheque.services.impl;


import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.dto.BookDto;
import com.arnaud.back.blibliotheque.repository.BookRepository;
import com.arnaud.back.blibliotheque.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookServicesImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServicesImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookDto> findAllByBookTitleAndBookAuthorAndAndBookKide(String titre, String auteur, String genre) {
        if(titre.equals("")){
            log.warn("le titre est vide");
        }else if (auteur.equals("")){
            log.warn("l'auteur est vide");
        }else if(genre.equals(""))
        {
            log.warn("le genre est vide ");
        }

        return bookRepository.findAllByBookTitleOrBookAuthorOrBookKide(titre,auteur,genre)
                .stream()
                .map(BookDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public List<Book> findBookByAvailableTrue() {

       return bookRepository.findBookByAvailableTrue();
    }


    @Override
    public List<Book> findBookByAvailableFalse() {
        return bookRepository.findBookByAvailableFalse();
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream().map(BookDto::fromEntity)
                .collect(Collectors.toList());
    }


}







