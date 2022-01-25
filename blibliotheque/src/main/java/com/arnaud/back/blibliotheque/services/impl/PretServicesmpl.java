package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.repository.BookRepository;
import com.arnaud.back.blibliotheque.repository.PretRepository;
import com.arnaud.back.blibliotheque.services.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class PretServicesmpl implements PretService {

    @Autowired
    PretRepository pretRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BookRepository bookRepository;



    @Override
    public Pret save(Pret pret, Integer bookid, Integer accountid) {
        //Book_id
        Book book = bookRepository.findById(bookid).orElse(null);
        //account_id
        Account account = accountRepository.findById(accountid).orElse(null);
        pret.setDateTimeJ(LocalDateTime.now());
        //
        pret.setAccount(account);
        pret.setBookpret(book);
        return pretRepository.save(pret);
    }

}
