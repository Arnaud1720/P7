package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.repository.BookRepository;
import com.arnaud.back.blibliotheque.repository.PretRepository;
import com.arnaud.back.blibliotheque.services.EmailSenderService;
import com.arnaud.back.blibliotheque.services.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PretServicesmpl implements PretService {

    @Autowired
    PretRepository pretRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    EmailSenderService emailSenderService;


    @Override
    public Pret save(Pret pret, Integer bookid, Integer accountid) {

        pret.setDateTimeJ(pret.getDateTimeJ().plusDays(2));
        //Book_id
        bookRepository.findById(bookid);
        //account_id
        accountRepository.findById(accountid);
        pret.setDateTimeJ(LocalDateTime.now());
        pret.setDateTimeFin(pret.getDateTimeJ().plusDays(2));
        //restriction sur le localDateTime

        return pretRepository.save(pret);

    }


    @Override
    public List<Object> findByDateTimeJOrderByDateTimeJ() {

        return pretRepository.findByDateTimeJOrderByDateTimeJ();

    }

    @Override
    public void deletePretById(Pret pret, Integer id, Integer accountid, Integer bookid) {
        // recupération de l'id du compte
        Account account = accountRepository.findById(accountid).orElse(null);
        //recupération de l'id du livre
        Book book = bookRepository.findById(bookid).orElse(null);
        pret.setAccount(account);
        pret.setBookpret(book);
        LocalDateTime dateJ = pret.getDateTimeJ();
        LocalDateTime dateJ2 = pret.getDateTimeFin();
        //recupéré la date de fin du pret && supprimé le pret quand >48h
        boolean isAfter = dateJ2.isAfter(dateJ);
        if (isAfter) {
            //supp pret
            pretRepository.deleteById(id);
        }
    }


    //afficher une liste de mail dont les prêt sont hors limite
    public List<Pret> displayMailEndDateOutofTime(Pret pret, Integer accountid, Integer bookid){
        // recupération de l'id du compte
        Account account = accountRepository.findById(accountid).orElse(null);
        //recupération de l'id du livre
        Book book = bookRepository.findById(bookid).orElse(null);
        pret.setAccount(account);
        pret.setBookpret(book);
        LocalDateTime dateJ = pret.getDateTimeJ();
        LocalDateTime dateJ2 = pret.getDateTimeFin();
        boolean isAfter = dateJ2.isAfter(dateJ);
    }


}

