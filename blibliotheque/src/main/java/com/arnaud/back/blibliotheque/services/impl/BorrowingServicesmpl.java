package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.Borrowing;
import com.arnaud.back.blibliotheque.repository.AccountRepository;
import com.arnaud.back.blibliotheque.repository.BookRepository;
import com.arnaud.back.blibliotheque.repository.BorrowingRepository;
import com.arnaud.back.blibliotheque.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class BorrowingServicesmpl implements BorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BookRepository bookRepository;



    @Override
    public Borrowing save(Borrowing borrowing, Integer bookid, Integer accountid) {
        //account_id
       Account account = accountRepository.findById(accountid).orElse(null);
        borrowing.setAccount(account);
        //Book_id
        Book book = bookRepository.findById(bookid).orElse(null);
        borrowing.setBookpret(book);
       borrowing.setDateTimeJ(LocalDateTime.now());
        borrowing.setDateTimeFin(borrowing.getDateTimeJ().plusDays(2));


        return borrowingRepository.save(borrowing);

    }


    @Override
    public List<Object> findByDateTimeJOrderByDateTimeJ() {

        return borrowingRepository.findByDateTimeJOrderByDateTimeJ();

    }

    @Override
    public void deleteBorrowingById(Borrowing borrowing, Integer id, Integer accountid, Integer bookid) {
        // recupération de l'id du compte
        Account account = accountRepository.findById(accountid).orElse(null);
        //recupération de l'id du livre
        Book book = bookRepository.findById(bookid).orElse(null);
        borrowing.setAccount(account);
        borrowing.setBookpret(book);
            borrowingRepository.deleteById(id);
        }




    //afficher une liste de mail dont les prêt sont hors limite
    public Optional<Account> displayMailEndDateOutofTime(Borrowing borrowing, Integer accountid, Integer bookid){
        Account account = accountRepository.findById(accountid).orElse(null);
        borrowing.setAccount(account);
        Book book = bookRepository.findById(bookid).orElse(null);
        borrowing.setBookpret(book);

        LocalDateTime dateJ = borrowing.getDateTimeJ();
        LocalDateTime dateJ2 = borrowing.getDateTimeFin();
        boolean isAfter = dateJ2.isAfter(dateJ);
        if(!isAfter){
            return Optional.empty();
        }
        assert account != null;
        return  accountRepository.findAccountByMail(account.getMail());

    }

    @Override
    public List<Borrowing> showLateLoan() {
        Borrowing pret = new Borrowing();
        LocalDateTime dateJ2 = pret.getDateTimeFin();
            return borrowingRepository.findAllByDateTimeFin(dateJ2);
    }

    @Override
    public List<Borrowing> findall() {
        return  borrowingRepository.findAll();
    }


}

