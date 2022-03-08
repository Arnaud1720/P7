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

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class BorrowingServicesmpl implements BorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;


    @Override
    public Borrowing save(Borrowing borrowing, Integer bookid, Integer accountid) {
       BigInteger doublon = borrowingRepository.checkDoublon();
        //account_id
       Account account = accountRepository.findById(accountid).orElse(null);
        borrowing.setAccount(account);
        //Book_id
        Book book = bookRepository.findById(bookid).orElse(null);
        borrowing.setBookpret(book);
     borrowing.setBookingDate(LocalDateTime.now());
       borrowing.setBookingDateEnd(LocalDateTime.now().plusDays(2));

        assert account != null;
        javaMailSenderImpl.sendEmail(account.getMail(),"votre réservation au nom de"+ " " +account.getFristName()+ " en date du " +borrowing.getBookingDate()
                        +" a été crée avec succès"
                ,"vous avez jusque au"+ borrowing.getBookingDateEnd()+" pour venir chercher vôtre réservation,sinon elle sera automatiquement supprimée");
        return borrowingRepository.save(borrowing);

    }


    @Override
    public List<Borrowing> findByDateTimeJOrderByDateTimeJ() {

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

    @Override
    public List<Borrowing> findBorrrowingOutOfTime() {

        LocalDateTime dateDuJour = LocalDateTime.now();
        List<Borrowing> borrowings = borrowingRepository.findAllByBookingDateEndLessThan(dateDuJour);

       return borrowings;
    }

    @Override
    public void  isOutOfTime() {
        borrowingRepository.isOutOfTime();
    }

    /**
     *
     * @return BIGINT test Agréga retourne les doublon par rapport au bookid dans la table borrowing
     */
    @Override
    public BigInteger checkDoublon() {
      return   borrowingRepository.checkDoublon();
    }
}

