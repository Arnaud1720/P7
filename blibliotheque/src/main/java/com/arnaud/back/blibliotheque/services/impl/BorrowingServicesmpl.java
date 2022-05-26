package com.arnaud.back.blibliotheque.services.impl;

import com.arnaud.back.blibliotheque.exception.EntityNotFoundException;
import com.arnaud.back.blibliotheque.exception.ErrorCode;
import com.arnaud.back.blibliotheque.model.*;
import com.arnaud.back.blibliotheque.repository.*;
import com.arnaud.back.blibliotheque.services.BorrowingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class BorrowingServicesmpl implements BorrowingService {

    final BorrowingRepository borrowingRepository;
    final AccountRepository accountRepository;
    final BookRepository bookRepository;
    private final JavaMailSenderImpl javaMailSenderImpl;
    private final ExemplaryRepository exemplaryRepository;
    final LoanRepository loanRepository;

    @Autowired
    public BorrowingServicesmpl(BorrowingRepository borrowingRepository, AccountRepository accountRepository, BookRepository bookRepository, JavaMailSenderImpl javaMailSenderImpl, ExemplaryRepository exemplaryRepository, LoanRepository loanRepository) {
        this.borrowingRepository = borrowingRepository;
        this.accountRepository = accountRepository;
        this.bookRepository = bookRepository;
        this.javaMailSenderImpl = javaMailSenderImpl;
        this.exemplaryRepository = exemplaryRepository;
        this.loanRepository = loanRepository;
    }

    @Override
    public Borrowing save(Borrowing borrowing, long exemplaryId, Integer accountid, Integer bookid) {

        // recupére l'utilisateur courrant
       Account account = accountRepository.findById(accountid).orElse(null);
        borrowing.setAccount(account);
        // récupére l'exemplaire courrant
        Exemplary exemplary = exemplaryRepository.findById(exemplaryId).orElse(null);
        borrowing.setExemplaryId(exemplary);
        Book book = bookRepository.findById(bookid).orElse(null);
        borrowing.setBook(book);
        borrowing.setBookingDate(LocalDateTime.now());
        borrowing.setBookingDateEnd(LocalDateTime.now().plusDays(2));
        int totalnbr = borrowingRepository.countBorrowingByBookBookId(bookid);
        borrowing.setTotal(totalnbr+1);
        int queue  =  borrowing.setCmpt(borrowingRepository.countBorrowingByBookBookId(bookid)+1);

        //vérifie que la liste ne soit pas égale au nombre max d'exemplaire (n'est pas supérieure à 2x le nombre d'exemplaire)
        //sinon lévé exception
        assert exemplary != null;
        if(queue>exemplary.getMaxExemplaryNumber()){
            log.error("max atteint");
            throw new EntityNotFoundException("le nombre maximum de réservation pour ce livre est atteint",ErrorCode.EXEMPLARY_LIMIT_REACHED);
        }


       Optional<Loan> loans = loanRepository.findById(Math.toIntExact(exemplaryId));
        /**
         * Il n’est pas possible pour un usager de réserver un ouvrage qu’il a déjà en cours d’emprunt
         */

      if(loans.isPresent()){
          throw new EntityNotFoundException("vous avez dèjà emprinté ce livre il est impossible de le réservé",ErrorCode.BORROWING_NOT_VALID);

      }else
      {
          javaMailSenderImpl.sendEmail(account.getMail(),"votre réservation au nom de"+ " " +account.getFristName()+ " en date du " +borrowing.getBookingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                          +" a été crée avec succès"
                  ,"vous avez jusque au"+ borrowing.getBookingDateEnd().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" pour venir chercher vôtre réservation,sinon elle sera automatiquement supprimée dans les 48 heures");
          return borrowingRepository.save(borrowing);
      }


    }



    @Override
    public List<Borrowing> findBorrrowingOutOfTime() {

        LocalDateTime dateDuJour = LocalDateTime.now();
        List<Borrowing> borrowings = borrowingRepository.findAllByBookingDateEndLessThan(dateDuJour);

       return borrowings;
    }

    @Override
    public void deleteBorrowingById( Integer id, Integer accountid, int bookid) {
        Borrowing borrowing = borrowingRepository.findById(id).orElse(null);
        // recupération de l'id du compte
        Account account = accountRepository.findById(accountid).orElseThrow(()->new EntityNotFoundException("aucun utilisateur trouvé",ErrorCode.USER_NOT_FOUND));
       LocalDateTime dateDebut = borrowing.getBookingDate();
      LocalDateTime dateRetour =  borrowing.getBookingDateEnd();
      int cmptTotal = borrowing.getTotal();
      int compt = borrowing.getCmpt();
      if(cmptTotal<0){
          borrowing.setTotal(0);
      }else if(compt<0){
          borrowing.setCmpt(0);
      }
        borrowingRepository.updateCmptBorrowing(bookid);
        borrowingRepository.updateTotalBorrowing(bookid);

        javaMailSenderImpl.sendEmail(account.getMail()," prêt au nom de"+ " " +account.getFristName()+" "+account.getLastName()
                ,"a été supprimer: "+" date de début : "+" " + dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" "+ " date limite de retour:"+" "+dateRetour.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        borrowingRepository.deleteById(id);

    }

    @Override
    public void  isOutOfTime() {
        borrowingRepository.isOutOfTime();
    }


    @Override
    public List<Borrowing> findAllByAccountId(Integer id) {
        return borrowingRepository.findAllByAccountId(id);
    }

    @Override
    public List<Borrowing> findall() {
        return borrowingRepository.findAll();
    }

    @Override
    public List<Borrowing> findAllByBookAvailable(boolean available) {
        return borrowingRepository.findAllByBookAvailable(available);
    }

    @Override
    public void deleteBorrowingByOutOfTimeTrue() {
        borrowingRepository.deleteBorrowingByOutOfTimeTrue();
    }


}

