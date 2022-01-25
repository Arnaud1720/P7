package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllByBookTitleOrBookAuthorOrBookKide(String titre, String auteur, String genre);

    List<Book> findBookByAvailableTrue();

    List<Book> findBookByAvailableFalse();

    List<Book> findAll();

    Book findByBookTitle(String bookTitle);

}

