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
import java.util.List;


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
       pret.setDateTimeJ(pret.getDateTimeJ().plusDays(2));
        //Book_id
        Book book = bookRepository.findById(bookid).orElse(null);
        //account_id
        Account account = accountRepository.findById(accountid).orElse(null);
        pret.setDateTimeJ(LocalDateTime.now());
        //restriction sur le localDateTime

        pret.setAccount(account);
        pret.setBookpret(book);




        return pretRepository.save(pret);


    }

    @Override
    public  List<Object[]> listPretOrderByDateJ() {
        return pretRepository.listPretOrderByDateJ();
    }

    @Override
    public List<Object> findByDateTimeJOrderByDateTimeJ() {
        
        return pretRepository.findByDateTimeJOrderByDateTimeJ();

    }



    /**
     * ne pas mettre de corrp de méthode dans une interface  la déclaré en privé
     *
     * @Param: Pret
     */

//    private void deletePret(Pret pret) throws Exception {
//        LocalDateTime d1 = pret.getDateTimeJ();
//        LocalDateTime d2 = d1.plusDays(2);
//        if(d1 == d2)
//        {
//            pretRepository.delete(pret);
//        }else {
//            throw new Exception("la date du jour n'a pas dépacé la limite de 48H");
//        }
//
//    }


}
