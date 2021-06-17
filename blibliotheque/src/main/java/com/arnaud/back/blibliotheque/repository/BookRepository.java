package com.arnaud.back.blibliotheque.repository;

import com.arnaud.back.blibliotheque.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findBookByAvailableTrue();
    List<Book> findBookByAvailableFalse();
    List<Book> findAll();
}

