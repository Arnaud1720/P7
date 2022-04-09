package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findAllByBookTitleOrBookAuthorOrBookKide(String titre, String auteur, String genre);

    List<Book> findBookByAvailableTrue();

    List<Book> findBookByAvailableFalse();

    List<Book> findAll();

    List<Book> findByBookTitle(String bookTitle);

}

